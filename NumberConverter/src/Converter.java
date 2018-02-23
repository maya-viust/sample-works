/**
 * Created by maya v
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Converter extends Application {
    private static TextField numInput;
    private static Text numOutput;
    private static String selected;

    private static RadioButton rbBin = new RadioButton("binary");
    private static RadioButton rbDec = new RadioButton("decimal");
    private static RadioButton rbHex = new RadioButton("hexadecimal");
    private static RadioButton rbOct = new RadioButton("octal");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Number Converter");

        final ToggleGroup origNum = new ToggleGroup();
        origNum.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (origNum.getSelectedToggle() != null) {
                selected = origNum.getSelectedToggle().toString();
            }
        });

        rbBin.setToggleGroup(origNum);
        rbDec.setToggleGroup(origNum);
        rbHex.setToggleGroup(origNum);
        rbOct.setToggleGroup(origNum);

        Button toBin = new Button("to binary");
        Button toDec = new Button("to decimal");
        Button toHex = new Button("to hexadecimal");
        Button toOct = new Button("to octal");

        toBin = binBtn(toBin);
        toDec = decBtn(toDec);
        toHex = hexBtn(toHex);
        toOct = octBtn(toOct);

        Label inTextLabel = new Label("Input: ");
        Label outTextLabel = new Label("Output: ");

        Label rbLabel = new Label("From: ");
        Label btnLabel = new Label("To: ");

        numInput = new TextField();
        numOutput = new Text();

        HBox finalNums = new HBox();
        finalNums.setSpacing(10);
        finalNums.getChildren().addAll(toBin, toDec, toHex, toOct);

        HBox origType = new HBox();
        origType.setSpacing(15);
        origType.getChildren().addAll(rbBin, rbDec, rbHex, rbOct);

        VBox labels = new VBox();
        labels.setSpacing(20);
        labels.getChildren().addAll(rbLabel, inTextLabel, btnLabel,
                outTextLabel);
        outTextLabel.setPadding(new Insets(15, 20, 20, 20));

        VBox userInputs = new VBox();
        userInputs.setSpacing(20);
        userInputs.getChildren().addAll(origType, numInput, finalNums,
                numOutput);

        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(labels, userInputs);
        root.setPrefHeight(200);
        root.setPrefWidth(450);

        primaryStage.setScene(new Scene(root, 450, 200));
        primaryStage.show();
    }

    //to bin
    private static Button binBtn(Button btn) {
        btn.setOnAction(event -> {
            if (processInput(numInput.getText())) {
                if (selected.equals(rbBin.toString())) {
                    numOutput.setText(Binary.toBin(numInput.getText()));
                } else if (selected.equals(rbDec.toString())) {
                    numOutput.setText(Decimal.toBin(numInput.getText()));
                } else if (selected.equals(rbHex.toString())) {
                    numOutput.setText(Hex.toBin(numInput.getText().
                            toUpperCase()));
                } else if (selected.equals(rbOct.toString())) {
                    numOutput.setText(Octal.toBin(numInput.getText()));
                }
            }
        });

        return btn;
    }

    //to dec
    private static Button decBtn(Button btn) {
        btn.setOnAction(event -> {
            if (processInput(numInput.getText())) {
                if (selected.equals(rbBin.toString())) {
                    numOutput.setText("" + Binary.toDec(numInput.getText()));
                } else if (selected.equals(rbDec.toString())) {
                    numOutput.setText("" + Decimal.toDec(numInput.getText()));
                } else if (selected.equals(rbHex.toString())) {
                    numOutput.setText("" + Hex.toDec(numInput.getText().
                            toUpperCase()));
                } else if (selected.equals(rbOct.toString())) {
                    numOutput.setText("" + Octal.toDec(numInput.getText()));
                }
            }
        });

        return btn;
    }

    //to hex
    private static Button hexBtn(Button btn) {
        btn.setOnAction(event -> {
            if (processInput(numInput.getText())) {
                if (selected.equals(rbBin.toString())) {
                    numOutput.setText(Binary.toHex(numInput.getText()));
                } else if (selected.equals(rbDec.toString())) {
                    numOutput.setText(Decimal.toHex(numInput.getText()));
                } else if (selected.equals(rbHex.toString())) {
                    numOutput.setText(Hex.toHex(numInput.getText().
                            toUpperCase()));
                } else if (selected.equals(rbOct.toString())) {
                    numOutput.setText(Octal.toHex(numInput.getText()));
                }
            }
        });

        return btn;
    }

    //to oct
    private static Button octBtn(Button btn) {
        btn.setOnAction(event -> {
            if (processInput(numInput.getText())) {
                if (selected.equals(rbBin.toString())) {
                    numOutput.setText(Binary.toOct(numInput.getText()));
                } else if (selected.equals(rbDec.toString())) {
                    numOutput.setText(Decimal.toOct(numInput.getText()));
                } else if (selected.equals(rbHex.toString())) {
                    numOutput.setText(Hex.toOct(numInput.getText().
                            toUpperCase()));
                } else if (selected.equals(rbOct.toString())) {
                    numOutput.setText(Octal.toOct(numInput.getText()));
                }
            }
        });

        return btn;
    }

    private static void noInputAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid input");
        alert.setContentText("Select a number type for the inputted value");
        alert.showAndWait();
    }

    private static void emptyInput() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid input");
        alert.setContentText("Type a number to be converted");
        alert.showAndWait();
    }

    private static void invalidAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid input");
        alert.setContentText("Input value is invalid for the type selected");
        alert.showAndWait();
    }

    private static boolean validBin(String input) {
        return input.matches("[01]+");
    }

    private static boolean validDec(String input) {
        return input.matches("[0-9]+");
    }

    private static boolean validHex(String input) {
        return input.toUpperCase().matches(
                "([A-F]*[0-9]*)+");
    }

    private static boolean validOct(String input) {
        return input.matches("[0-7]+");
    }

    private static boolean processInput(String input) {
        boolean validInput = false;

        if (selected == null) {
            noInputAlert();
            return false;
        }

        if (input.isEmpty()) {
            emptyInput();
            return false;
        }

        if (selected.equals(rbBin.toString())) {
            validInput = validBin(input);
        } else if (selected.equals(rbDec.toString())) {
            validInput = validDec(input);
        } else if (selected.equals(rbHex.toString())) {
            validInput = validHex(input.toUpperCase());
        } else if (selected.equals(rbOct.toString())) {
            validInput = validOct(input);
        }

        if (!validInput) {
            invalidAlert();
        }
        return validInput;
    }
}
