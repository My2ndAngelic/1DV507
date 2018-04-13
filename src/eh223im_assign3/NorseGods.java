package eh223im_assign3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NorseGods extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        Label l1 = new Label("Norse Gods and other beings");
        l1.setFont(new Font(30));
        pane.setTop(l1);

        ListView<NorseGod> lv = new ListView<>();
        pane.setLeft(lv);

        TextFlow tf = new TextFlow();

        ArrayList <NorseGod> norseGod = new ArrayList<>();

        norseGod.add(new NorseGod("Loki","Æsir",readFile("Loki.txt")));
        norseGod.add(new NorseGod("Freyja","Vanir",readFile("Freyja.txt")));
        norseGod.add(new NorseGod("Thor","Æsir",readFile("Thor.txt")));
        norseGod.add(new NorseGod("Odin","Æsir",readFile("Odin.txt")));
        norseGod.add(new NorseGod("Lóðurr","Æsir",readFile("Lóðurr.txt")));
        norseGod.add(new NorseGod("Víðarr","Æsir",readFile("Víðarr.txt")));
        norseGod.add(new NorseGod("Vafþrúðnir","Jötnar",readFile("Vafþrúðnir.txt")));
        norseGod.add(new NorseGod("Freyr","Vanir",readFile("Freyr.txt")));


        ObservableList<NorseGod> ol = FXCollections.observableArrayList(norseGod);

        lv.setItems(ol);

        Text name = new Text();
        Text race = new Text();
        Text desc = new Text();

        tf.getChildren().addAll(name,race,desc);

        lv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                name.setText(lv.getSelectionModel().getSelectedItem().getName());
                name.setFont(new Font(20));

                race.setText("\n"+lv.getSelectionModel().getSelectedItem().getRace());
                race.setFont(new Font(15));

                desc.setText("\n"+"\n"+lv.getSelectionModel().getSelectedItem().getDesc());
                desc.setFont(new Font(15));

            }
        });

        tf.setPrefSize(480,500);

        ScrollPane sp = new ScrollPane();
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setFitToWidth(true);
        sp.setContent(tf);
        sp.fitToWidthProperty();
        pane.setRight(sp);

        pane.setPadding(new Insets(10,20,20,20));

        Scene scene = new Scene(pane,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String readFile(String dir) {
        try {
            File f = new File(dir);
            StringBuilder s = new StringBuilder();
            Scanner scanner = new Scanner(f);
            do {
                s.append(scanner.nextLine()).append("\n");
            } while (scanner.hasNextLine());
            return s.toString();
        } catch (FileNotFoundException ignored) {

        }
        throw new RuntimeException("Cannot read file "+ dir);
    }
}
