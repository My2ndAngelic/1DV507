package eh223im_assign2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CompoundInterest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            //

            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);

            // Title
            Text title = new Text("Compound Interest");
            title.setFont(new Font(28));
            pane.add(title, 0, 0, 2, 1);
            pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
            pane.setHgap(5.5);
            pane.setVgap(5.5);

            // Start amount
            pane.add(new Label("Start amount: "), 0, 1);
            TextField startamount = new TextField();
            pane.add(startamount, 1, 1);

            // Annual interest
            pane.add(new Label("Interest: "), 0, 2);
            TextField interest = new TextField();
            pane.add(interest, 1, 2);

            // Number of year
            pane.add(new Label("Number of years: "), 0, 3);
            TextField year = new TextField();
            pane.add(year, 1, 3);

            // Calculate button
            Button cal = new Button("Calculate");
            pane.add(cal, 0, 4);

            // Result print
            Label result = new Label();
            pane.add(result, 0, 5,2,1);
            final String[] res = new String[1];

            /* Set button action
             * Formula: start * (1+interest/100)^year -> Double value
             * Warning: 4.9999999994 is left the same. Probably I should round it, but that is not a good thing to do.
             */
            GridPane.setHalignment(cal, HPos.LEFT);
            cal.setOnAction(e -> {
                res[0] = (Double.toString((Double.parseDouble(startamount.getText())*Math.pow((1+(Double.parseDouble(interest.getText())/100)),Double.parseDouble(year.getText())))));
                result.setText("In total that will be "+res[0]);
            });
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ignored) {
            // No action if user mess around
        }
    }
}
