package controls;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class PracticeWithControls extends Application{


        public void start(Stage stage) throws Exception {


            stage.setScene(createOptionalElements());
            stage.setTitle("Practice with controls");
            stage.show();
        }

        //Buttons
        public Scene createButtons(){

            //Creating a new button
            Button button = new Button("Click me");
            button.setPrefHeight(20);
            button.setPrefWidth(300);
            button.setAlignment(Pos.BOTTOM_RIGHT);

            //This is our layout for controls
            VBox vBox = new VBox();
            vBox.getChildren().add(button);

            //Set the spacing with my layout
            vBox.setAlignment(Pos.CENTER);
            vBox.setPadding(new Insets(20));

            //Assign an event handler
            Random random = new Random();
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    button.setText("you clicked, here is a random #:" +  random.nextInt(100));
                }
            });

            return new Scene(vBox,500,500);
        }

        //Text elements - Text, Label, TextField, TextArea
        public Scene createTextElements(){

            VBox verticalStack = new VBox();
            verticalStack.setAlignment(Pos.CENTER);
            verticalStack.setPadding(new Insets(10));
            verticalStack.setSpacing(10);

            //Add a banner using a text class
            Text banner = new Text();
            banner.setText("Enter information");
            banner.setFont(Font.font("Vani", FontWeight.BOLD, 30));
            banner.setUnderline(true);

            verticalStack.getChildren().add(banner);

            //Lets add a few label/entry fields
            Label nameLabel = new Label("Name: ");
            nameLabel.setAlignment(Pos.CENTER_LEFT);
            nameLabel.setPrefWidth(50);


            TextField nameEntry = new TextField();
            nameEntry.setPrefWidth(200);

            //Group together my controls and add them to a parent layout
            HBox horizontalStack = new HBox();
            horizontalStack.setAlignment(Pos.CENTER);
            horizontalStack.getChildren().addAll(nameLabel,nameEntry);
            verticalStack.getChildren().add(horizontalStack);



            Label bioLabel = new Label("Bio: ");
            bioLabel.setAlignment(Pos.CENTER_RIGHT);
            bioLabel.setPrefWidth(50);

            TextArea bioEntry = new TextArea();
            bioEntry.setPrefWidth(200);
            bioEntry.setWrapText(true);

            horizontalStack = new HBox();
            horizontalStack.setAlignment(Pos.CENTER);
            horizontalStack.getChildren().addAll(bioEntry,bioLabel);
            verticalStack.getChildren().add(horizontalStack);

            return new Scene(verticalStack,500,500);
        }


        //Checkboxes, radio buttons
        public Scene createOptionalElements(){

            Text header = new Text("Favorite Colors");
            header.setUnderline(true);

            //Primary layout
            VBox box = new VBox();
            box.setAlignment(Pos.CENTER);
            box.setPadding(new Insets(10));
            box.setSpacing(10);

            box.getChildren().add(header);

            //Create several options
            String[] choices = {"Blue", "Purple", "Pink", "White"};
            CheckBox[] checkBoxes = new CheckBox[choices.length];

            for(int i = 0; i < choices.length; i++){

                CheckBox checkBox = new CheckBox(choices[i]);
                checkBox.setPrefWidth(100);
                checkBox.setAlignment(Pos.CENTER_LEFT);

                checkBoxes[i] = checkBox;
                box.getChildren().add(checkBox);
            }

            //Assign event handlers to each checkbox
            for(int i = 0; i < checkBoxes.length; i++){

                 CheckBox chkBox = checkBoxes[i];
                chkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                        chkBox.setText("You clicked me" + newValue);
                    }
                });
            }


            //Radio buttons
            RadioButton firstButton = new RadioButton();
            RadioButton secondButton = new RadioButton();

            ToggleGroup groupRadioButtons = new ToggleGroup();
            firstButton.setToggleGroup(groupRadioButtons);
            secondButton.setToggleGroup(groupRadioButtons);
            box.getChildren().addAll(firstButton,secondButton);

            return new Scene(box,500,500);
        }

        //Display images?
        public Scene createOrShowImages(){

            return null;
        }


        //Lists - dropdown (ComboBox), ListView
        public Scene createLists(){

            return null;
        }

        //Dialog boxes - Color picker, Date picker
        public Scene createDialogs(){

            return null;
        }



}
