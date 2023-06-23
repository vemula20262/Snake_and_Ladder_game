package com.example.snakeandladder;



import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import org.controlsfx.control.spreadsheet.Grid;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;


public class HelloController {
    public ImageView diceImage;
    public GridPane frontGridPane;
    public GridPane gridPane;
    public ImageView player22;
    public ImageView player1img;
    public ImageView player11;
    public ImageView player2img;
    public ImageView win;
    public Pane bottomPane;
    public Pane frontPane;
    public ImageView backgroungImg;
    public Label playerNum;
    @FXML
    private ImageView token1;

    @FXML
    private ImageView token2;

    public Button dice;
    public Label num;
    int i;
    Token player1;
    @FXML
    Token player2;
    HashMap<Integer, int[]> sandl;

    public void initialize(){
        player1 = new Token(token1, "violet");
        player2 = new Token(token2, "red");
        i = 1;
        /*
        sandl = new HashMap<Integer, int[]>();
        snake = new HashMap<Integer, int[]>();
        snake.put(99, new int[]{3, 0,80});
        snake.put(95, new int[]{3, 4,76});
        snake.put(94, new int[]{5, 7,53});
        snake.put(90, new int[]{6, 9,50});
        snake.put(55, new int[]{9, 2,18});
        snake.put(63, new int[]{5, 0,60});
        snake.put(43, new int[]{8, 1,22});
        sandl.put(4, new int[]{8, 4,25});
        sandl.put(8, new int[]{7, 9,31});
        sandl.put(27, new int[]{6, 5,46});
        sandl.put(42, new int[]{3, 0,80});
        sandl.put(58, new int[]{3, 3,77});
        sandl.put(69, new int[]{1, 7,93});

         */
        sandl = new HashMap<Integer, int[]>();
        sandl.put(4, new int[]{8, 4,25});
        sandl.put(8, new int[]{7, 9,31});
        sandl.put(27, new int[]{6, 5,46});
        sandl.put(42, new int[]{3, 0,80});
        sandl.put(58, new int[]{3, 3,77});
        sandl.put(69, new int[]{1, 7,93});
        sandl.put(99, new int[]{3, 0,80});
        sandl.put(95, new int[]{3, 4,76});
        sandl.put(94, new int[]{5, 7,53});
        sandl.put(90, new int[]{6, 9,50});
        sandl.put(55, new int[]{9, 2,18});
        sandl.put(63, new int[]{5, 0,60});
        sandl.put(43, new int[]{8, 1,22});
    }

    public void diceMove(MouseEvent mouseEvent) throws FileNotFoundException {

        Random rand = new Random();
        int rand_int1 = rand.nextInt(6) + 1;
        num.setText(String.valueOf(rand_int1));

        if(i%2 !=0) {
            player2img.setVisible(false);
            player22.setVisible(true);
            player1img.setVisible(true);
            player11.setVisible(false);
            if(player1.getCount() == 0){
                if(rand_int1 == 1) {
                    player1.setCurrRow(10);
                    player1.setCount(1);
                }
                player2img.setVisible(true);
                player22.setVisible(false);
                player1img.setVisible(false);
                player11.setVisible(true);
                i++;
                return;
            }
            if((player1.getCount() + rand_int1) <= 100){
            player1.moveLftRit(rand_int1);
            if(sandl.containsKey(player1.getCount())){
                animate(sandl.get(player1.getCount())[1], sandl.get(player1.getCount())[0], sandl.get(player1.getCount())[2],player1);
                System.out.println("Blue");
                System.out.println("CurrRow = " + player1.getCurrRow());
                System.out.println("CurrCol = " + player1.getCurrCol());
                System.out.println();

            }

        }
            player2img.setVisible(true);
            player22.setVisible(false);
            player1img.setVisible(false);
            player11.setVisible(true);
        }
        if(i%2 == 0) {
            player2img.setVisible(true);
            player22.setVisible(false);
            player1img.setVisible(false);
            player11.setVisible(true);
            if(player2.getCount() == 0 ){
                if(rand_int1 == 1) {
                    player2.setCurrRow(10);
                    player2.setCount(1);
                }
                player2img.setVisible(false);
                player22.setVisible(true);
                player1img.setVisible(true);
                player11.setVisible(false);
                i++;
                return;
            }
            if((player2.getCount() + rand_int1) <= 100) {

                player2.moveLftRit(rand_int1);


                if (sandl.containsKey(player2.getCount())) {
                    animate(sandl.get(player2.getCount())[1], sandl.get(player2.getCount())[0], sandl.get(player2.getCount())[2], player2);
                    System.out.println("Red");
                    System.out.println("CurrRow = " + player2.getCurrRow());
                    System.out.println("CurrCol = " + player2.getCurrCol());
                    System.out.println();
                }



            }
            player2img.setVisible(false);
            player22.setVisible(true);
            player1img.setVisible(true);
            player11.setVisible(false);

            }
        if(player1.getCount() == 100){
            bottomPane.getChildren().remove(frontGridPane);
            bottomPane.getChildren().remove(frontPane);
            bottomPane.getChildren().remove(backgroungImg);
            bottomPane.getChildren().remove(player1img);
            bottomPane.getChildren().remove(player2img);
            bottomPane.getChildren().remove(player11);
            bottomPane.getChildren().remove(player22);
            bottomPane.getChildren().remove(dice);
            playerNum.setText("Player 1");
            return;


        }
        if(player2.getCount() == 100){
            bottomPane.getChildren().remove(frontGridPane);
            bottomPane.getChildren().remove(frontPane);
            bottomPane.getChildren().remove(backgroungImg);
            bottomPane.getChildren().remove(player1img);
            bottomPane.getChildren().remove(player2img);
            bottomPane.getChildren().remove(player11);
            bottomPane.getChildren().remove(player22);
            bottomPane.getChildren().remove(dice);
            playerNum.setText("Player 2");
            return;
        }
        i++;





    }

    public void animate(int col, int row, int count, Token player){
        Bounds bounds1 = frontGridPane.getCellBounds(player.getCurrCol(), player.getCurrRow());
        Bounds bounds2 = frontGridPane.getCellBounds(col,row);
        System.out.println(bounds2);
        System.out.println(bounds1);
        double x = bounds2.getMaxX() - bounds1.getMaxX();
        double y = bounds2.getMaxY() - bounds1.getMaxY();
        System.out.println(x);
        System.out.println(y);



        //apply translation to x,y of new location
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setToX(x);
        translateTransition.setToY(y);
        translateTransition.setNode(player.token);
        translateTransition.play();
        translateTransition.setOnFinished(e->{
            frontGridPane.getChildren().remove(player.token);
            player.token.setTranslateX(0);player.token.setTranslateY(0);
            frontGridPane.add(player.token, col, row);
            player.setCurrRow(row);
            player.setCurrCol(col);
            player.setCount(count);
            System.out.println(player.getCurrCol());
            System.out.println(player.getCurrRow());

        });
    }

}

class Token{
    private int count;
    private int currRow;
    private int currCol;
    ImageView token;
    private String colour;
    GridPane gridPane;

    public Token(ImageView token, String colour){
        this.count = 0;
        this.token = token;
        GridPane.setRowIndex(this.token, 11);
        currRow = 11;
        GridPane.setColumnIndex(this.token, 0);
        currCol = 0;
        if(GridPane.getColumnIndex(this.token) == null)
            currCol = 0;
        else
            currCol = GridPane.getColumnIndex(this.token);
        this.colour = colour;
    }

    public void moveLftRit(int steps){
        System.out.println(colour);
        System.out.println("Steps = " + steps);
        int stepsTaken = 0;
        System.out.println("StepsTaken = " + stepsTaken);
        System.out.println("Initial location = (" + currRow + ", " + currCol + ")");
        if((count >= 1 && count <= 10) || (count >= 21 && count <= 30)
                || (count >= 41 && count <= 50) || (count >= 61 && count <= 70) || (count >= 81 && count <= 90)) {
            System.out.println("Moving Right...");
            if((getCurrCol() + steps) > 9){
                System.out.println("getCurrCol() + steps) > 9");
                stepsTaken = 9 - getCurrCol();
                System.out.println("StepsTaken = " + stepsTaken);
                currCol = currCol + stepsTaken;
                System.out.println("Next location = (" + currRow + ", " + currCol + ")");
                GridPane.setColumnIndex(token, currCol);
                if(stepsTaken < steps) {
                    System.out.println("    StepsTaken < " + steps + "Moving up");
                    moveUp();
                    stepsTaken++;
                    System.out.println("    StepsTaken = " + stepsTaken);
                }
                if(stepsTaken < steps){
                    currCol = currCol - steps + stepsTaken;
                    System.out.println("    StepsTaken < " + steps + " Moving to column = " + currCol);
                    GridPane.setColumnIndex(token, currCol);
                    stepsTaken = steps;
                    System.out.println("    StepsTaken = " + stepsTaken);
                }
            }
            else {
                currCol = currCol + steps;
                System.out.println("StepsTaken " + steps + "Moving to column = " + currCol);
                GridPane.setColumnIndex(token, currCol);
            }
        }
        else {
            System.out.println("Moving Left...");
            if((getCurrCol() - steps) < 0){
                System.out.println("getCurrCol() - steps) > 0");
                stepsTaken = getCurrCol();
                System.out.println("StepsTaken = " + stepsTaken);
                currCol = currCol - stepsTaken;
                System.out.println("Next location = (" + currRow + ", " + currCol + ")");
                GridPane.setColumnIndex(token, currCol);
                if(stepsTaken < steps) {
                    System.out.println("    StepsTaken < " + steps + "Moving up");
                    moveUp();
                    stepsTaken++;
                    System.out.println("    StepsTaken = " + stepsTaken);

                }
                if(stepsTaken < steps){
                    currCol = currCol + steps - stepsTaken;
                    System.out.println("    StepsTaken < " + steps + "Moving to column = " + currCol);
                    GridPane.setColumnIndex(token, currCol);
                    stepsTaken = steps;
                    System.out.println("    StepsTaken = " + stepsTaken);
                }
            }
            else {
                currCol = currCol - steps;
                System.out.println("StepsTaken " + steps + "Moving to column = " + currCol);
                GridPane.setColumnIndex(token, currCol);
            }

        }
        count += steps;
        System.out.println("Count = " + count);
        System.out.println();
    }

    public void moveUp(){
        currRow--;
        GridPane.setRowIndex(token,currRow);
    }

    public int getCurrRow(){
        return currRow;
    }

    public int getCurrCol(){
        return currCol;
    }

    public void setCurrRow(int row){
        currRow = row;
        GridPane.setRowIndex(this.token, currRow);
    }
    public void setCurrCol(int col){
        currCol = col;
        GridPane.setColumnIndex(this.token, currCol);
    }
    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }


}




