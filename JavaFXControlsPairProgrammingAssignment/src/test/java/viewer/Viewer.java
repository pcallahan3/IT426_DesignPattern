package viewer;

/*Name: Patrick Callahan
  Date: 1/22/18
  File Name: JavaFXControlsPairProgrammingAssignment

 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.File;
import java.net.MalformedURLException;

public class Viewer extends Application {

    private RadioButton[] radioButtons;
    private String[] animals = {"Bear", "Cat", "Owl", "Parrot"};
    private String[] imgs = {"bear", "cat", "owl", "parrot"};
    private final int MAX_BUTTONs = 4;
    ToggleGroup group = new ToggleGroup();
    Image image;
    ImageView imageControl;


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Select an image!");
        primaryStage.setScene(getScene());
        primaryStage.show();
    }

    public Scene getScene(){
        StackPane root = new StackPane();

        VBox vbox = new VBox(60);
        HBox hbox = new HBox(15);

        radioButtons = new RadioButton[MAX_BUTTONs];

        //Looping over RadioButton objects, setting text, getting user data, and adding in to the HBox object
        for (int i = 0; i < MAX_BUTTONs; i++) {
            radioButtons[i] = new RadioButton(animals[i]);
            radioButtons[i].setFont(Font.font("Verdana", 12));
            radioButtons[i].setUserData(imgs[i]);
            radioButtons[i].setToggleGroup(group);
            hbox.getChildren().add(radioButtons[i]);
        }

        //Setting an ChangeListener for the RadioButtons so when a user clicks a button an animal image will appear
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
                @Override
                public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                    if (group.getSelectedToggle() != null) {
                        image = null;
                        try {
                            image = new Image(new File("images/" + group.getSelectedToggle().getUserData() + ".jpg")
                                    .toURI().toURL().toString(), 250, 250, false, false);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                        imageControl = new ImageView(image);
                        imageControl.setImage(image);
                        root.getChildren().addAll(imageControl);
                    }
                }

            });


            hbox.setAlignment(Pos.TOP_CENTER);
            hbox.setPadding(new Insets(30));
            vbox.setPadding(new Insets(30));
            vbox.getChildren().add(hbox);
            root.getChildren().add(hbox);

            return new Scene(root,350,400);
        }


        public static void main (String[]args){

            Application.launch(args);
        }

}

