package eh223im_assign2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A Yahtzee program. It's a mess.
 * @author eh223im
 */

public class Yahtzee extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);

            // Title
            Text title = new Text("Yahtzee");
            title.setFont(new Font(28));
            pane.add(title, 0, 0, 5, 1);
            pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
            pane.setHgap(5.5);
            pane.setVgap(5.5);

            // Check box
//            pane.add(new Image());

            int[] res = {1,2,3,4,5};

            // Specify folder contains 1, 2, 3, 4, 5, 6 (dot) png file here or create a folder name Dice and put all files there.
            String g = Paths.get(".").toAbsolutePath().normalize().toString();
            System.out.println("Working directory: "+g);

            String folder = g+"/Dice/";

            int num = 1;
            FileInputStream fis = new FileInputStream(folder+num+".png");
            Image one = new Image(fis);
            num++;
            fis = new FileInputStream(folder+num+".png");
            Image two = new Image(fis);
            num++;
            fis = new FileInputStream(folder+num+".png");
            Image three = new Image(fis);
            num++;
            fis = new FileInputStream(folder+num+".png");
            Image four = new Image(fis);
            num++;
            fis = new FileInputStream(folder+num+".png");
            Image five = new Image(fis);
            num++;
            fis = new FileInputStream(folder+num+".png");
            Image six = new Image(fis);


            pane.add(new ImageView(one),0,1);
            pane.add(new ImageView(two),1,1);
            pane.add(new ImageView(three),2,1);
            pane.add(new ImageView(four),3,1);
            pane.add(new ImageView(five),4,1);

            // Check box
            CheckBox first = new CheckBox();
            CheckBox second = new CheckBox();
            CheckBox third = new CheckBox();
            CheckBox fourth = new CheckBox();
            CheckBox fifth = new CheckBox();

            pane.add(first,0,2);
            pane.add(second,1,2);
            pane.add(third,2,2);
            pane.add(fourth,3,2);
            pane.add(fifth,4,2);

            // Calculate button
            Button roll = new Button("Roll");
            pane.add(roll, 0, 3);

            // Reset
            Button tryAgain = new Button("Try again");
            pane.add(tryAgain,1,3);

            Button reset = new Button("Reset");
            pane.add(reset,2,3);

            int rTurn = 5;

            // Result print
            Label result = new Label("You have "+rTurn + " turn(s) left.");
            pane.add(result, 0, 5,5,1);

            /*
            * ROLL
            * */
            GridPane.setHalignment(roll, HPos.LEFT);
            GridPane.setHalignment(title,HPos.CENTER);
            GridPane.setHalignment(first,HPos.CENTER);
            GridPane.setHalignment(second,HPos.CENTER);
            GridPane.setHalignment(third,HPos.CENTER);
            GridPane.setHalignment(fourth,HPos.CENTER);
            GridPane.setHalignment(fifth,HPos.CENTER);

            Random r = new Random();

            AtomicInteger turn = new AtomicInteger(rTurn);
            roll.setDefaultButton(true);

            // Roll if not selected, return result if 0 turn left
            roll.setOnAction((ActionEvent e) -> {
                if (turn.intValue() > 0) {
                    if (!first.isSelected()) {
                        int k = r.nextInt(6) + 1;
                        res[0] = k;
                        try {
                            pane.add(new ImageView(new Image(new FileInputStream(folder + k + ".png"))), 0, 1);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }

                    if (!second.isSelected()) {
                        int k = r.nextInt(6) + 1;
                        res[1] = k;
                        try {
                            pane.add(new ImageView(new Image(new FileInputStream(folder + k + ".png"))), 1, 1);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }

                    if (!third.isSelected()) {
                        int k = r.nextInt(6) + 1;
                        res[2] = k;
                        try {
                            pane.add(new ImageView(new Image(new FileInputStream(folder + k + ".png"))), 2, 1);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }

                    if (!fourth.isSelected()) {
                        int k = r.nextInt(6) + 1;
                        res[3] = k;
                        try {
                            pane.add(new ImageView(new Image(new FileInputStream(folder + k + ".png"))), 3, 1);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }

                    if (!fifth.isSelected()) {
                        int k = r.nextInt(6) + 1;
                        res[4] = k;
                        try {
                            pane.add(new ImageView(new Image(new FileInputStream(folder + k + ".png"))), 4, 1);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                    turn.getAndDecrement();
                    result.setText("You have " + turn + " turn(s) left.");

                    System.out.println(Arrays.toString(res));
                    if (turn.intValue() == 0) {
                        roll.setDisable(true);

                        int ones = 0;
                        int twos = 0;
                        int threes = 0;
                        int fours = 0;
                        int fives = 0;
                        int sixes = 0;

                        // Count dice
                        for (int i = 0; i < 5; i++) {
                            switch (res[i]) {
                                case 1:
                                    ones++;
                                    break;
                                case 2:
                                    twos++;
                                    break;
                                case 3:
                                    threes++;
                                    break;
                                case 4:
                                    fours++;
                                    break;
                                case 5:
                                    fives++;
                                    break;
                                case 6:
                                    sixes++;
                                    break;
                                default:
                                    break;
                            }
                        }

                        System.out.println("We have " + ones + " ones, " + twos + " twos, " + threes + " threes, " + fours + " fours, " + fives + " fives, " + sixes + " sixes.");

                        // Check condition
                        // Low quality
                        if (ones == 5 || twos == 5 || threes == 5 || fours == 5 || fives == 5 || sixes == 5) {
                            result.setText("It's Yahtzee.");
                        } else if (ones == 4 || twos == 4 || threes == 4 || fours == 4 || fives == 4 || sixes == 4) {
                            result.setText("It's Four of a kind.");
                        } else if (ones == 3 || twos == 3 || threes == 3 || fours == 3 || fives == 3 || sixes == 3) {
                            if (ones == 2 || twos == 2 || threes == 2 || fours == 2 || fives == 2 || sixes == 2) {
                                result.setText("It's Full house.");
                            } else {
                                result.setText("It's Three of a kind.");
                            }
                        } else if ((ones == 1 && twos == 1 && threes == 1 && fours == 1 && fives == 1) || (twos == 1 && threes == 1 && fours == 1 && fives == 1 && sixes == 1)) {
                            result.setText("It's Large Straight");
                        } else if ((ones == 1 && twos == 1 && threes == 1 && fours == 1) ||(twos == 1 && threes == 1 && fours == 1 && fives == 1) || (threes == 1 && fours == 1 && fives == 1 && sixes == 1)){
                            result.setText("It's Small Straight");
                        } else if (result.getText().equals("You have " + 0 + " turn(s) left.")) {
                            result.setText("It's Chance.");
                        }
                    }
                }
            });

            tryAgain.setOnAction(e -> {
                if (turn.intValue() == 0) {
                    if (turn.intValue() > 0) {
                        tryAgain.setDisable(true);
                    }
                    turn.set(rTurn);
                    result.setText("You have " + turn + " turn(s) left.");
                    roll.setDisable(false);
                }
            });

            reset.setOnAction(e -> {
                turn.set(rTurn);
                result.setText("You have " + turn + " turn(s) left.");
                roll.setDisable(false);
                for (int i = 0; i<5; i++) {
                    res[i] = i+1;
                    try {
                        pane.add(new ImageView(new Image(new FileInputStream(folder + (i+1) + ".png"))), i, 1);
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println(Arrays.toString(res));
            });

            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
