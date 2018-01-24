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


public class CalculatorUI extends Application {

    private static final int MAX_BUTTONS = 16;
    private Button[] integerButtons;
    private TextField numberDisplay = new TextField();
    GridPane paneButton = new GridPane();
    BorderPane root = new BorderPane();
    private String[] buttonText = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "x",
            "0", "Enter", " " , "/"
    };


    @Override
    public void start(Stage primaryStage) {

        numberDisplayPref();
        iterateOverButtons();

        //If button equals enter then make the 14th button disappear and set preffered width
        if (buttonText[13].equalsIgnoreCase("enter")) {
            integerButtons[14].setVisible(false);
        }

        Scene scene = new Scene(getBorderPain(root), 300, 275);
        primaryStage.setScene(scene);
        getCSSFile(scene);
        primaryStage.setTitle("JavaFX Calculator");
        primaryStage.show();

    }

        // Set and align the numberDisplay
        private void numberDisplayPref() {
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
            paneButton.setPadding(new Insets(15, 5, 15, 5));
            paneButton.setVgap(10);
            paneButton.setHgap(10);
            root.setPadding(new Insets(50, 10, 80, 10));
            root.setId("root");
            root.setBottom(numberDisplay);
            root.setCenter(paneButton);
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
                paneButton.add(integerButtons[i], i % columnRows , i / columnRows);
            }
        }


}