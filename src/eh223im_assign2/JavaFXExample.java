package eh223im_assign2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;

public class JavaFXExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(20, 50, "Hello World");
        Group root = new Group();
        root.getChildren().add(text);
        Scene scene = new Scene(root, 200, 100);
        primaryStage.setTitle("Hello there!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
