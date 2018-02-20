package eh223im_assign3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Rotate extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dialogues");
        VBox layout = new VBox();
        layout.setPadding(new Insets(5, 5, 5, 5));
        layout.setSpacing(5);
        Button aButton = new Button("Press me");
        aButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.getButtonTypes().add(new ButtonType("Nani"));
            alert.setTitle("Important Information");
            alert.setHeaderText("Congratulation");
            alert.setContentText("You are already gay.");
            alert.showAndWait();
        });
        layout.getChildren().addAll(aButton);
        Scene theScene = new Scene(layout, 300, 200);
        primaryStage.setScene(theScene);
        primaryStage.show();
    }
}
