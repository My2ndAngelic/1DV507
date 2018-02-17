package eh223im_assign2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

// Designed for 1280 x 800 screen, dialog size is 500 x 700

public class Snowman extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Snow
        Polygon snowPlatform = new Polygon();
        snowPlatform.getPoints().addAll(0.0,700.0,
                500.0,700.0,
                500.0,600.0,
                0.0,600.0);
        snowPlatform.setFill(Color.WHITE);



        //Snowman
        Circle bottom = new Circle(250,500,130,Color.WHITE);
        Circle mid = new Circle(250,380,100,Color.WHITE);
        Circle top = new Circle(250,250,70,Color.WHITE);

        Circle eyeLeft = new Circle(220,220,6, Color.BLACK);
        Circle eyeRight = new Circle(280,220,6,Color.BLACK);
        Circle nose = new Circle(250,250,10,Color.BLACK);
        Polygon mouth = new Polygon(230.5,270.0, 270.0,270.0, 250.0,290.0);
        mouth.setFill(Color.BLACK);

        Line handLeft = new Line(100,275,200,360);
        handLeft.setStroke(Color.BLACK);
        handLeft.setStrokeWidth(10.0);

        Line handRight = new Line(400,275,300,360);
        handRight.setStrokeWidth(10.0);
        handRight.setStroke(Color.BLACK);


        //Accessories
        Circle button1 = new Circle(250,320,8,Color.BLACK);
        Circle button2 = new Circle(250,360,8,Color.BLACK);
        Circle button3 = new Circle(250,400,8,Color.BLACK);

        Line scarf = new Line(195,295,310,295);
        scarf.setStroke(Color.PINK);
        scarf.setStrokeWidth(8.0);

        Polygon hat = new Polygon(200.0,200.0, 300.0,200.0, 250.0,100.0);
        hat.setFill(Color.RED);
        Circle hatBell = new Circle(250,100,10,Color.WHITE);


        //Sun
        Circle sun = new Circle(380,100,50,Color.YELLOW);


        // Hidden platform
        Polygon snowPlatform2 = new Polygon();
        snowPlatform2.getPoints().addAll(800.0,1000.0,
                2000.0,1000.0,
                2000.0,600.0,
                800.0,600.0);
        snowPlatform2.setFill(Color.WHITE);

        Text text = new Text();
        text.setFont(new Font(15));
        text.setX(900);
        text.setY(100);
        text.setText("Welcome to the other side!");


        Group root = new Group();

        // Falling snow effect
        for (int i = 0; i < 300; i++) {
            root.getChildren().add(new Circle(new Random().nextInt(500), new Random().nextInt(700), 1.5, Color.WHITE));
        }

        // Add all elements
        root.getChildren().addAll(handLeft,handRight,snowPlatform,bottom,mid,top,eyeLeft,eyeRight,nose,mouth,button1,button2,button3,scarf,hat,hatBell,sun,snowPlatform2,text);

        // Main presenter
        Scene scene = new Scene(root, 500, 700);
        scene.setFill(Color.CYAN);
        primaryStage.setTitle("Snowman");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
