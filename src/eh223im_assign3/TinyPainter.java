package eh223im_assign3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;

// Adopted from: https://www.youtube.com/watch?v=gjZQB6BmyK4
public class TinyPainter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        StackPane sp = new StackPane();
        Scene scene = new Scene(sp, 800, 600);


        Canvas c1 = new Canvas(800, 600);
        Canvas c2 = new Canvas(800, 600);

        ColorPicker cp = new ColorPicker();
        ColorPicker cp2 = new ColorPicker();


        GraphicsContext gc;
        gc = c1.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.5);

        cp.setValue(Color.BLUE);
        cp2.setValue(Color.YELLOW);

        ComboBox cb = new ComboBox();
        cb.getItems().addAll("Pencil", "Line", "Rectangle", "Circle", "Eraser", "Eraser (Rectangle)");


        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setValue(3);

        Slider slider2 = new Slider();
        slider2.setVisible(true);
        slider2.setMin(0);
        slider2.setMax(2);
        slider2.setValue(1);
        slider2.setMinorTickCount(0);
        slider2.setMajorTickUnit(1);
        slider2.setSnapToTicks(true);
        slider2.setShowTickMarks(true);
        slider2.setShowTickLabels(true);
        setSlider(slider2);

        slider2.setVisible(false);
        cp2.setVisible(false);

        // Drawing actions
        cb.setOnAction(e -> {
            if (cb.getValue().equals("Pencil")) {
                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMousePressed(g -> {
                });
                scene.setOnMouseDragged(g -> {
                });
                scene.setOnMouseReleased(g -> {
                });

                slider2.setVisible(false);
                cp2.setVisible(false);

                scene.setOnMouseClicked(f -> {
                    gc.setStroke(cp.getValue());
                    gc.setFill(cp2.getValue());
                    gc.setLineWidth(slider.getValue());
                    gc.stroke();
                });

                scene.setOnMousePressed(f -> {
                    gc.setStroke(cp.getValue());
                    gc.setFill(cp2.getValue());
                    gc.setLineWidth(slider.getValue());
                    gc.beginPath();
                    gc.lineTo(f.getSceneX(), f.getSceneY());
                    gc.stroke();
                });

                scene.setOnMouseDragged(f -> {
                    gc.setStroke(cp.getValue());
                    gc.setFill(cp2.getValue());
                    gc.setLineWidth(slider.getValue());
                    gc.lineTo(f.getSceneX(), f.getSceneY());
                    gc.stroke();
                });

            } else if (cb.getValue().equals("Circle")) {

                slider2.setVisible(true);
                cp2.setVisible(true);

                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseDragged(g -> {
                });
                final double[] x = new double[3];
                final double[] y = new double[3];


                scene.setOnMousePressed(f -> {
                    gc.setStroke(cp.getValue());
                    gc.setFill(cp2.getValue());
                    gc.setLineWidth(slider.getValue());
                    gc.beginPath();
                    x[0] = f.getSceneX();
                    y[0] = f.getSceneY();
                });

                scene.setOnMouseReleased(f -> {
                    x[1] = f.getSceneX();
                    y[1] = f.getSceneY();
                    x[2] = (x[0] - x[1]) * (x[0] - x[1]);
                    y[2] = (y[0] - y[1]) * (y[0] - y[1]);
                    final double k = Math.sqrt(x[2] + y[2]);

                    gc.strokeOval(Math.abs(x[0] - k), Math.abs(y[0] - k), k * 2, k * 2);

                    if (slider2.getValue() == 0) {
                        gc.strokeOval(Math.abs(x[0] - k), Math.abs(y[0] - k), k * 2, k * 2);
                    } else if (slider2.getValue() == 2) {
                        gc.fillOval(Math.abs(x[0] - k), Math.abs(y[0] - k), k * 2, k * 2);
                    } else {
                        gc.strokeOval(Math.abs(x[0] - k), Math.abs(y[0] - k), k * 2, k * 2);
                        gc.fillOval(Math.abs(x[0] - k), Math.abs(y[0] - k), k * 2, k * 2);
                    }
                });

            } else if (cb.getValue().equals("Line")) {

                slider2.setVisible(false);
                cp2.setVisible(false);

                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseDragged(g -> {
                });

                final double[] x = new double[1];
                final double[] y = new double[1];

                mousePressForShape(scene, cp, cp2, gc, slider, x, y);

                scene.setOnMouseReleased(f -> {
                    gc.strokeLine(x[0], y[0], f.getSceneX(), f.getSceneY());
                    x[0] = 0;
                    y[0] = 0;
                });
            } else if (cb.getValue().equals("Rectangle")) {
                slider2.setVisible(true);
                cp2.setVisible(true);

                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseDragged(g -> {
                });

                final double[] x = new double[3];
                final double[] y = new double[3];
                mousePressForShape(scene, cp, cp2, gc, slider, x, y);

                scene.setOnMouseReleased(f -> {
                    gc.setLineWidth(slider.getValue());
                    x[1] = f.getSceneX();
                    y[1] = f.getSceneY();

                    if (x[0] > x[1]) {
                        x[2] = x[0];
                        x[0] = x[1];
                        x[1] = x[2];
                    }

                    if (y[0] > y[1]) {
                        y[2] = y[0];
                        y[0] = y[1];
                        y[1] = y[2];
                    }

                    if (slider2.getValue() == 0) {
                        gc.strokeRect(x[0], y[0], x[1] - x[0], y[1] - y[0]);
                    } else if (slider2.getValue() == 2) {
                        gc.fillRect(x[0], y[0], x[1] - x[0], y[1] - y[0]);
                    } else {
                        gc.strokeRect(x[0], y[0], x[1] - x[0], y[1] - y[0]);
                        gc.fillRect(x[0], y[0], x[1] - x[0], y[1] - y[0]);
                    }
                });
            } else if (cb.getValue().equals("Eraser")) {
                slider2.setVisible(false);
                cp2.setVisible(false);

                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMousePressed(g -> {
                });
                scene.setOnMouseDragged(g -> {
                });
                scene.setOnMouseReleased(g -> {
                });


                scene.setOnMouseClicked(f -> {
                    gc.setStroke(Color.WHITE);
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(slider.getValue());
                    gc.stroke();
                    f.consume();
                });

                scene.setOnMousePressed(f -> {
                    gc.setStroke(Color.WHITE);
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(slider.getValue());
                    gc.beginPath();
                    gc.lineTo(f.getSceneX(), f.getSceneY());
                    gc.stroke();
                    f.consume();
                });

                scene.setOnMouseDragged(f -> {
                    gc.setStroke(Color.WHITE);
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(slider.getValue());
                    gc.lineTo(f.getSceneX(), f.getSceneY());
                    gc.stroke();
                    f.consume();
                });
            } else if (cb.getValue().equals("Eraser (Rectangle)")) {
                slider2.setVisible(false);
                cp2.setVisible(false);

                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseClicked(g -> {
                });
                scene.setOnMouseDragged(g -> {
                });

                final double[] x = new double[3];
                final double[] y = new double[3];
                scene.setOnMousePressed(f -> {
                    gc.setStroke(Color.WHITE);
                    gc.setFill(Color.WHITE);
                    gc.setLineWidth(slider.getValue());
                    x[0] = f.getSceneX();
                    y[0] = f.getSceneY();
                });

                scene.setOnMouseReleased(f -> {
                    gc.setLineWidth(slider.getValue());
                    x[1] = f.getSceneX();
                    y[1] = f.getSceneY();

                    if (x[0] > x[1]) {
                        x[2] = x[0];
                        x[0] = x[1];
                        x[1] = x[2];
                    }

                    if (y[0] > y[1]) {
                        y[2] = y[0];
                        y[0] = y[1];
                        y[1] = y[2];
                    }
                    gc.clearRect(x[0], y[0], x[1] - x[0], y[1] - y[0]);
                });
            }
        });

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20, 20, 5, 20));
        gp.setHgap(20);
        gp.setGridLinesVisible(false);

        cb.setTooltip(new Tooltip("Choose your tool to draw"));
        slider.setTooltip(new Tooltip("Stroke size"));
        slider2.setTooltip(new Tooltip("Choose your preferences for Rectangle and Circle"));
        cp.setTooltip(new Tooltip("Stroke color"));
        cp2.setTooltip(new Tooltip("Fill color"));

        gp.add(cb, 0, 0);
        gp.add(cp, 2, 0);
        gp.add(slider, 1, 0);
        gp.add(cp2, 3, 0);
        gp.add(slider2, 4, 0);

        // Main stage
        sp.getChildren().addAll(c1, c2, gp);
        sp.setStyle("-fx-background-color: white");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mousePressForShape(Scene scene, ColorPicker cp, ColorPicker cp2, GraphicsContext gc, Slider slider, double[] x, double[] y) {
        scene.setOnMousePressed(f -> {
            gc.setStroke(cp.getValue());
            gc.setFill(cp2.getValue());
            gc.setLineWidth(slider.getValue());
            x[0] = f.getSceneX();
            y[0] = f.getSceneY();
        });
    }

    private void setSlider(Slider slider) {
        slider.setLabelFormatter(new StringConverter<>() {
            @Override
            public String toString(Double object) {
                if (object == 0) {
                    return "Stroke";
                } else if (object == 1) {
                    return "Stroke and Fill";
                } else return "Fill";
            }

            @Override
            public Double fromString(String string) {
                switch (string) {
                    case "Stroke":
                        return 0d;
                    case "Fill":
                        return 1d;
                    default:
                        return 2d;
                }
            }
        });
    }
}
