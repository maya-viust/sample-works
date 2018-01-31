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

public class ShapeArea extends Application {
    Stage appStage; //primargy stage

    //All buttons
    Button circBack, triBack, rectBack, parBack, rhomBack;
    Button calcCirc, calcTri, calcRect, calcPar, calcRhom;
    Button circView, triView, rectView, parView, rhomView;

    //All scenes
    Scene homeScene, circScene, triScene, rectScene, parScene, rhomScene;

    //area will be displayed to exactly 2 decimal places
    DecimalFormat df = new DecimalFormat("#.00");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        appStage = primaryStage;

        //create grids for each scene
        GridPane homeGrid = new GridPane();
        homeGrid.setAlignment (Pos.CENTER);
        homeGrid.setHgap(10);
        homeGrid.setVgap(10);
        homeGrid.setPadding(new Insets(25, 25, 25, 25));

        GridPane circGrid = new GridPane();
        circGrid.setAlignment (Pos.CENTER);
        circGrid.setHgap(10);
        circGrid.setVgap(10);
        circGrid.setPadding(new Insets(25, 25, 25, 25));

        GridPane triGrid = new GridPane();
        triGrid.setAlignment (Pos.CENTER);
        triGrid.setHgap(10);
        triGrid.setVgap(10);
        triGrid.setPadding(new Insets(25, 25, 25, 25));

        GridPane rectGrid = new GridPane();
        rectGrid.setAlignment (Pos.CENTER);
        rectGrid.setHgap(10);
        rectGrid.setVgap(10);
        rectGrid.setPadding(new Insets(25, 25, 25, 25));

        GridPane parGrid = new GridPane();
        parGrid.setAlignment (Pos.CENTER);
        parGrid.setHgap(10);
        parGrid.setVgap(10);
        parGrid.setPadding(new Insets(25, 25, 25, 25));

        GridPane rhomGrid = new GridPane();
        rhomGrid.setAlignment (Pos.CENTER);
        rhomGrid.setHgap(10);
        rhomGrid.setVgap(10);
        rhomGrid.setPadding(new Insets(25, 25, 25, 25));

        //set all scene titles
        Text circTitle = new Text("Circle");
        Text triTitle = new Text ("Triangle");
        Text rectTitle = new Text("Square or Rectangle");
        Text parTitle = new Text ("Parallelogram");
        Text rhomTitle = new Text("Rhombus");
        Text homeTitle = new Text("Calculate Area of a Shape from Below");

        //set font
        circTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        triTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        rectTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        parTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        rhomTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        homeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));

        //add to respective grid
        //(name, column start, row start, columns spanned, rows spanned)
        circGrid.add(circTitle, 0, 0, 2, 1);
        triGrid.add(triTitle, 0, 0, 2, 1);
        rectGrid.add(rectTitle, 0, 0, 2, 1);
        parGrid.add(parTitle, 0, 0, 2, 1);
        rhomGrid.add(rhomTitle, 0, 0, 2, 1);
        homeGrid.add(homeTitle, 0, 0, 2, 1);

        //All labels
        Label radius = new Label("Radius:");

        Label triHeight = new Label("Height:");
        Label triBase = new Label("Base:");

        Label rectWidth = new Label("Width:");
        Label rectHeight = new Label("Height:");

        Label parBase = new Label("Base:");
        Label parHeight = new Label("Height:");

        Label rhomDiag1 = new Label("Diagonal 1:");
        Label rhomDiag2 = new Label("Diagonal 2:");

        Label circArea = new Label("Area:");
        Label triArea = new Label("Area:");
        Label rectArea = new Label("Area:");
        Label parArea = new Label("Area:");
        Label rhomArea = new Label("Area:");

        //add labels to respective grid
        //(name, column, row)
        circGrid.add(radius, 0, 1);
        circGrid.add(circArea, 0, 2);

        triGrid.add(triBase, 0, 1);
        triGrid.add(triHeight, 0, 2);
        triGrid.add(triArea, 0, 3);

        rectGrid.add(rectWidth, 0, 1);
        rectGrid.add(rectHeight, 0, 2);
        rectGrid.add(rectArea, 0, 3);

        parGrid.add(parBase, 0, 1);
        parGrid.add(parHeight, 0, 2);
        parGrid.add(parArea, 0, 3);

        rhomGrid.add(rhomDiag1, 0, 1);
        rhomGrid.add(rhomDiag2, 0, 2);
        rhomGrid.add(rhomArea, 0, 3);

        //user input text fields
        TextField radiusInput = new TextField();

        TextField triBaseInput = new TextField();
        TextField triHeightInput = new TextField();

        TextField rectWidthInput = new TextField();
        TextField rectHeightInput = new TextField();

        TextField parBaseInput = new TextField();
        TextField parHeightInput = new TextField();

        TextField rhomDiag1Input = new TextField();
        TextField rhomDiag2Input = new TextField();

        //add textfields to respective grid
        circGrid.add(radiusInput, 1, 1);

        triGrid.add(triBaseInput, 1, 1);
        triGrid.add(triHeightInput, 1, 2);

        rectGrid.add(rectWidthInput, 1, 1);
        rectGrid.add(rectHeightInput, 1, 2);

        parGrid.add(parBaseInput, 1, 1);
        parGrid.add(parHeightInput, 1, 2);

        rhomGrid.add(rhomDiag1Input, 1, 1);
        rhomGrid.add(rhomDiag2Input, 1, 2);

        //Instantiate all buttons and add to respective grids
        calcCirc = new Button("Calculate Area");
        HBox hcalcCirc = new HBox(15);
        calcCirc.setAlignment(Pos.BOTTOM_CENTER);
        hcalcCirc.getChildren().add(calcCirc);
        circGrid.add(hcalcCirc, 1, 3);

        calcTri = new Button("Calculate Area");
        HBox hcalcTri = new HBox(15);
        hcalcTri.setAlignment(Pos.BOTTOM_CENTER);
        hcalcTri.getChildren().add(calcTri);
        triGrid.add(hcalcTri, 1, 4);

        calcRect = new Button("Calculate Area");
        HBox hcalcRect = new HBox(15);
        hcalcRect.setAlignment(Pos.BOTTOM_CENTER);
        hcalcRect.getChildren().add(calcRect);
        rectGrid.add(hcalcRect, 1, 4);

        calcPar = new Button("Calculate Area");
        HBox hcalcPar = new HBox(15);
        hcalcPar.setAlignment(Pos.BOTTOM_CENTER);
        hcalcPar.getChildren().add(calcPar);
        parGrid.add(hcalcPar, 1, 4);

        calcRhom = new Button("Calculate Area");
        HBox hcalcRhom = new HBox(15);
        hcalcRhom.setAlignment(Pos.BOTTOM_CENTER);
        hcalcRhom.getChildren().add(calcRhom);
        rhomGrid.add(hcalcRhom, 1, 4);

        //create area display text and add to respective grid
        Text circAT = new Text();
        circGrid.add(circAT, 1, 2);

        Text triAT = new Text();
        triGrid.add(triAT, 1, 3);

        Text rectAT = new Text();
        rectGrid.add(rectAT, 1, 3);

        Text parAT = new Text();
        parGrid.add(parAT, 1, 3);

        Text rhomAT = new Text();
        rhomGrid.add(rhomAT, 1, 3);

        //set calculator button actions
        calcCirc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //calculates area, displays as blue text
                try {
                    circAT.setFill(Color.rgb(77, 217, 221));
                    circAT.setText(circArea(
                        Double.parseDouble(radiusInput.getText())));
                } catch (NumberFormatException nfe) {
                    //displays red invalid input if numbers are not inputted
                    circAT.setFill(Color.rgb(232, 48, 2));
                    circAT.setText("Invalid input.");
                }
            }
        });

        calcTri.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //calculates area, displays as blue text
                try {
                    triAT.setFill(Color.rgb(77, 217, 221));
                    triAT.setText(triArea(
                        Double.parseDouble(triBaseInput.getText()),
                        Double.parseDouble(triHeightInput.getText())));
                } catch (NumberFormatException nfe) {
                    //displays red invalid input if numbers are not inputted
                    triAT.setFill(Color.rgb(232, 48, 2));
                    triAT.setText("Invalid input.");
                }
            }
        });

        calcRect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //calculates area, displays as blue text
                try {
                    rectAT.setFill(Color.rgb(77, 217, 221));
                    rectAT.setText(rectArea(
                        Double.parseDouble(rectWidthInput.getText()),
                        Double.parseDouble(rectHeightInput.getText())));
                } catch (NumberFormatException nfe) {
                    //displays red invalid input if numbers are not inputted
                    rectAT.setFill(Color.rgb(232, 48, 2));
                    rectAT.setText("Invalid input.");
                }
            }
        });

        calcPar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //calculates area, displays as blue text
                try {
                    parAT.setFill(Color.rgb(77, 217, 221));
                    parAT.setText(parArea(
                        Double.parseDouble(parBaseInput.getText()),
                        Double.parseDouble(parHeightInput.getText())));
                } catch (NumberFormatException nfe) {
                    //displays red invalid input if numbers are not inputted
                    parAT.setFill(Color.rgb(232, 48, 2));
                    parAT.setText("Invalid input.");
                }
            }
        });

        calcRhom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //calculates area, displays as blue text
                try {
                    rhomAT.setFill(Color.rgb(77, 217, 221));
                    rhomAT.setText(rhomArea(
                        Double.parseDouble(rhomDiag1Input.getText()),
                        Double.parseDouble(rhomDiag2Input.getText())));
                } catch (NumberFormatException nfe) {
                    //displays red invalid input if numbers are not inputted
                    rhomAT.setFill(Color.rgb(232, 48, 2));
                    rhomAT.setText("Invalid input.");
                }
            }
        });



        //Goes to respective user input scene
        circView = new Button("Circle");
        circView.setOnAction(e-> ButtonClicked(e));
        HBox hcalcView = new HBox(15);
        hcalcView.setAlignment(Pos.BASELINE_CENTER);
        hcalcView.getChildren().add(circView);
        homeGrid.add(hcalcView, 1, 2);

        triView = new Button("Triangle");
        triView.setOnAction(e-> ButtonClicked(e));
        HBox htriView = new HBox(15);
        htriView.setAlignment(Pos.BASELINE_CENTER);
        htriView.getChildren().add(triView);
        homeGrid.add(htriView, 1, 3);

        rectView = new Button("Square or Rectangle");
        rectView.setOnAction(e-> ButtonClicked(e));
        HBox hrectView = new HBox(15);
        hrectView.setAlignment(Pos.BASELINE_CENTER);
        hrectView.getChildren().add(rectView);
        homeGrid.add(hrectView, 1, 4);


        parView = new Button("Parallelogram");
        parView.setOnAction(e-> ButtonClicked(e));
        HBox hparView = new HBox(15);
        hparView.setAlignment(Pos.BASELINE_CENTER);
        hparView.getChildren().add(parView);
        homeGrid.add(hparView, 1, 5);

        rhomView = new Button("Rhombus");
        rhomView.setOnAction(e-> ButtonClicked(e));
        HBox hrhomView = new HBox(15);
        hrhomView.setAlignment(Pos.BASELINE_CENTER);
        hrhomView.getChildren().add(rhomView);
        homeGrid.add(hrhomView, 1, 6);

        //returns to home scene
        circBack = new Button("Back");
        circBack.setOnAction(e-> ButtonClicked(e));
        circGrid.add(circBack, 2, 3);

        triBack = new Button("Back");
        triBack.setOnAction(e-> ButtonClicked(e));
        triGrid.add(triBack, 2, 4);

        rectBack = new Button("Back");
        rectBack.setOnAction(e-> ButtonClicked(e));
        rectGrid.add(rectBack, 2, 4);

        parBack = new Button("Back");
        parBack.setOnAction(e-> ButtonClicked(e));
        parGrid.add(parBack, 2, 4);

        rhomBack = new Button("Back");
        rhomBack.setOnAction(e-> ButtonClicked(e));
        rhomGrid.add(rhomBack, 2, 4);

        //create scenes
        homeScene = new Scene(homeGrid, 350, 350);
        circScene = new Scene(circGrid, 350, 350);
        triScene = new Scene(triGrid, 350, 350);
        rectScene = new Scene(rectGrid, 350, 350);
        parScene = new Scene(parGrid, 350, 350);
        rhomScene = new Scene(rhomGrid, 350, 350);

        primaryStage.setTitle("Calculate Area of a Shape");
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    public void ButtonClicked(ActionEvent e) {
        if (e.getSource() == circBack) {
            appStage.setScene(homeScene);
        } else if (e.getSource() == triBack) {
            appStage.setScene(homeScene);
        } else if (e.getSource() == rectBack) {
            appStage.setScene(homeScene);
        }else if (e.getSource() == parBack) {
            appStage.setScene(homeScene);
        }else if (e.getSource() == rhomBack) {
            appStage.setScene(homeScene);
        }else if (e.getSource() == circView) {
            appStage.setScene(circScene);
        } else if (e.getSource() == triView) {
            appStage.setScene(triScene);
        } else if (e.getSource() == rectView) {
            appStage.setScene(rectScene);
        } else if (e.getSource() == parView) {
            appStage.setScene(parScene);
        } else if (e.getSource() == rhomView) {
            appStage.setScene(rhomScene);
        }
    }

    public String circArea(double radius) {
        double area = 2.0 * Math.PI * radius;
        return df.format(area);
    }

    public String triArea(double base, double height) {
        double area = 0.5 * base * height;
        return df.format(area);
    }

    public String rectArea(double width, double height) {
        double area = width * height;
        return df.format(area);
    }

    public String parArea(double base, double height) {
        double area = base * height;
        return df.format(area);
    }

    public String rhomArea(double diag1, double diag2) {
        double area = 0.5 * (diag1 * diag2);
        return df.format(area);
    }
}
