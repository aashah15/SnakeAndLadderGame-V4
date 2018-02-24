package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public int playerPos[][] = new int[10][10];
    public int sAndLPos[][] = new int[6][6];

    public int rand = 0;
    public Label randResult;
    public Label gameResult;

    public static final int tileSize = 80;
    public static final int width = 10;
    public static final int height = 10;

    public Circle player1;
    public Circle player2;

    public boolean player1Turn = false;
    public boolean player2Turn = false;

    public int player1Position = 1;
    public int player2Position = 1;

    public int player1XPos = 150;
    public int player1YPos = 840;

    public int player2XPos = 640;
    public int player2YPos = 840;

    public int posCir1 = 1;
    public int posCir2 = 1;

    public int[] intArray1= new int[4];
    public int[] intArray2 = new int[4];

    public boolean gameStart = false;
    public Button gameButton;

    private Group titleGroup = new Group();

    private Parent createContent(){
        // root
        Pane root = new Pane();
        root.setPrefSize(width * tileSize, (height * tileSize) + 80);
        root.getChildren().addAll(titleGroup);

        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                Tile tile = new Tile(tileSize, tileSize);
                tile.setTranslateX(j * tileSize);
                tile.setTranslateY(i * tileSize);
                titleGroup.getChildren().add(tile);

            }

        }

        MovePlayer movePlayer1 = new MovePlayer(1,150,840,1);

        player1 = new Circle(40);
        player1.setId("Player 1");
        player1.setFill(Color.GREEN);
        player1.getStyleClass().add("Style.css");
        player1.setTranslateX(movePlayer1.getxPos());
        player1.setTranslateY(movePlayer1.getyPos());

        MovePlayer movePlayer2 = new MovePlayer(1,640,840,1);

        player2 = new Circle(40);
        player2.setId("Player 2");
        player2.setFill(Color.RED);
        player2.getStyleClass().add("Style.css");
        player2.setTranslateX(movePlayer2.getxPos());
        player2.setTranslateY(movePlayer2.getyPos());

        Button button1 = new Button("Player 1");
        button1.setTranslateX(20);
        button1.setTranslateY(820);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameStart){
                    if(player1Turn){
                        getDiceValue();
                        randResult.setText(String.valueOf(rand));

                        player1Position += rand;

                        intArray1 =  movePlayer1.movePlayer(player1XPos, player1YPos, posCir1, rand);

                        player1XPos = intArray1[0];
                        player1YPos = intArray1[1];
                        posCir1 = intArray1[2];
                        rand = intArray1[3];

                        translatePlayer(player1XPos, player1YPos, player1);

                        intArray1 = movePlayer1.moveNewPlayer(player1Position, player1XPos, player1YPos, posCir1);

                        player1XPos = intArray1[0];
                        player1YPos = intArray1[1];
                        posCir1 = intArray1[2];
                        player1Position = intArray1[3];

                        translatePlayer(player1XPos, player1YPos, player1);
                        if(player1XPos < 30 || player1YPos < 30 || player1Position == 100) {
                            gameResult.setTranslateX(530);
                            gameResult.setText("Player One Won");
                            gameButton.setText("Start Again");
                            gameStart = false;
                        }
                        player1Turn = false;
                        player2Turn = true;
                        if(gameStart)
                            gameResult.setText("Player Two turn");
                    }
                }
            }


        });



        Button button2 = new Button("Player 2");
        button2.setTranslateX(700);
        button2.setTranslateY(820);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(gameStart){
                    if(player2Turn){
                        getDiceValue();
                        randResult.setText(String.valueOf(rand));

                        player2Position += rand;

                        intArray2 = movePlayer2.movePlayer(player2XPos, player2YPos, posCir2, rand);

                        player2XPos = intArray2[0];
                        player2YPos = intArray2[1];
                        posCir2 = intArray2[2];
                        rand = intArray2[3];

                        translatePlayer(player2XPos, player2YPos, player2);

                        intArray2 = movePlayer2.moveNewPlayer(player2Position, player2XPos, player2YPos, posCir2);
                        player2XPos = intArray2[0];
                        player2YPos = intArray2[1];
                        posCir2 = intArray2[2];
                        player2Position = intArray2[3];

                        translatePlayer(player2XPos, player2YPos, player2);

                        if(player2XPos < 30 || player2YPos < 30 || player2Position == 100) {
                            gameResult.setTranslateX(530);
                            gameResult.setText("Player Two Won");
                            gameButton.setText("Start Again");
                            gameStart = false;
                        }
                        player2Turn = false;
                        player1Turn = true;
                        if(gameStart)
                            gameResult.setText("Player One turn");

                    }
                }
            }
        });


        gameButton = new Button("Start Game");
        gameButton.setTranslateX(350);
        gameButton.setTranslateY(820);

        gameButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!gameStart) {
                    gameStart = true;
                    randResult.setText("Dice Result");
                    randResult.setTranslateX(220);
                    gameButton.setText("Game Started");

                    player1XPos = 40;
                    player1YPos = 760;

                    player2XPos = 40;
                    player2YPos = 760;

                    player1Position = 1;
                    player2Position = 1;

                    posCir1 = 1;
                    posCir2 = 1;

                    player1.setTranslateX(player1XPos);
                    player1.setTranslateY(player1YPos);
                    player2.setTranslateX(player2XPos);
                    player2.setTranslateY(player2YPos);

                    rand = (int) (Math.random() * 2 + 1);
                    if (rand == 1) {
                        player1Turn = true;
                        gameResult.setText("Player One Turn");
                    } else {
                        player2Turn = true;
                        gameResult.setText("Player Two Turn");
                    }
                }
            }

        });

        randResult = new Label("Dice Result");
        randResult.setTranslateX(230);
        randResult.setTranslateY(830);

        gameResult = new Label("Game Result");
        gameResult.setTranslateX(490);
        gameResult.setTranslateY(830);

        Image img = new Image("snakebg.jpeg");
        ImageView imageView = new ImageView();
        imageView.setImage(img);
        imageView.setFitWidth(800);
        imageView.setFitHeight(800);
        titleGroup.getChildren().addAll(imageView,player1, player2, button1, button2, gameButton, randResult, gameResult);

        return root;

    }

    public void getDiceValue(){
        rand = (int)(Math.random() * 6 +1);
    }




    public void translatePlayer(int x, int y, Circle b){

        TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
    }

      @Override
    public void start(Stage primaryStage) throws Exception{

        Scene scene = new Scene(createContent());
        primaryStage.setTitle("Snake and Ladder Game");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}

