package ui;


/*
    Name: Patrick Callahan
    Date: 1/23/2018
    File Name: Calculator.java
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.io.File;
import java.net.URL;


/**
 *  Calculator class to hold Calculator user interface
 *
 * @version 1.0
 * @author  Patrick Callahan
 *
 */
public class CalculatorUI extends Application {

    private static final int MAX_BUTTONS = 15;

    private Button[] integerButtons;
    private TextField numberDisplay = new TextField();
    GridPane gridPane = new GridPane();
    BorderPane root = new BorderPane();
    private String[] buttonText = {"7", "8", "9", "+", "4", "5", "6", "-",
                                   "1", "2", "3", "*", "0", "Enter",  "/"
    };


    @Override
    /**
     *
     * Start method to render Scence and componeents
     *
     * @param stage Render Stage stage
     *
     */
    public void start(Stage stage) {

        numberDisplayAlignment();
        iterateOverButtons();

        //If button equals "enter" then make the 14th button disappear and set preffered width of "enter" button
        if (buttonText[13].equalsIgnoreCase("enter")) {
            //integerButtons[14].setVisible(true);
            //integerButtons[13].setPrefWidth(180);
            GridPane.setColumnSpan(integerButtons[13], 2);
        }

        Scene scene = new Scene(getBorderPain(root), 300, 275);
        stage.setScene(scene);
        getCSSFile(scene);
        stage.setTitle("Calculator");
        stage.show();

    }

        // Set and align the numberDisplay
        private void numberDisplayAlignment() {
            numberDisplay.setAlignment(Pos.CENTER_RIGHT);
            numberDisplay.setPrefSize(20, 10);
        }

        //Get css file
        private Scene getCSSFile(Scene scene) {
            File f = new File("calculator.css");
            scene.getStylesheets().clear();
            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
            return scene;
        }

        //Get BorderPane, set padding, set id, set position of number display, and Vgap and Hgap
        //for buttons
        private BorderPane getBorderPain(BorderPane root) {
            gridPane.setPadding(new Insets(15, 5, 15, 5));
            gridPane.setVgap(10);
            gridPane.setHgap(10);
            root.setPadding(new Insets(50, 10, 80, 10));
            root.setId("root");
            root.setBottom(numberDisplay);
            root.setCenter(gridPane);
            return root;
        }

        //Iterate over buttons and create a 4 x 4 column grid
        private void iterateOverButtons(){
            int columnRows = 4;
            integerButtons = new Button[MAX_BUTTONS];
            for (int i = 0; i < integerButtons.length; ++i) {
                integerButtons[i] = new Button(buttonText[i]);
                integerButtons[i].setId("buttons");
                integerButtons[i].setPrefSize(60, 80);
                gridPane.add(integerButtons[i], i % columnRows , i / columnRows);
            }
        }


}