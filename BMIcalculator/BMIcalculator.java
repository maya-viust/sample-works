import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.lang.Math;
import java.text.DecimalFormat;

public class BMIcalculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculate Your Body Mass Index");

        GridPane grid = new GridPane();
        grid.setAlignment (Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding (new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Body Mass Index (BMI)");

        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label weight = new Label("Weight in Pounds:");
        Label height = new Label("Height in Inches:");
        Label bmi = new Label("BMI:");

        grid.add(weight, 0, 1);
        grid.add(height, 0, 2);
        grid.add(bmi, 0, 3);

        TextField weightInput = new TextField();
        TextField heightInput = new TextField();

        grid.add(weightInput, 1, 1);
        grid.add(heightInput, 1, 2);

        Button calc = new Button("Calculate");
        HBox hbtn = new HBox(10);
        hbtn.setAlignment(Pos.BOTTOM_CENTER);
        hbtn.getChildren().add(calc);
        grid.add(hbtn, 1, 4);

        Text actiontarget = new Text();
        grid.add(actiontarget, 1, 3);

        calc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //display area
                    actiontarget.setFill(Color.rgb(77, 217, 221));
                    actiontarget.setText(calcBMI(
                        Double.parseDouble(weightInput.getText()),
                        Double.parseDouble(heightInput.getText())));
                } catch (NumberFormatException nfe) {
                    actiontarget.setFill(Color.rgb(232, 48, 2));
                    actiontarget.setText("Invalid input.");
                }
            }
        });

        Scene scene = new Scene(grid, 350, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String calcBMI(double weight, double height) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format((weight / (height * height)) * 703);
    }
}
