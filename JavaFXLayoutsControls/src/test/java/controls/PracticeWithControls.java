package controls;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

public class PracticeWithControls extends Application{


    public void start(Stage stage) throws Exception {


        stage.setScene(createDialogs());
        stage.setTitle("Practice with controls");
        stage.show();
    }

    //Buttons
    public Scene createButtons(){

        //Creating a new button
        final Button button = new Button("Click me");
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
        final Random random = new Random();
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
    public Scene createOrShowImages() throws MalformedURLException {

        //Load image into control
        Image image = new Image(new File("images/Desert.jpg")
                .toURI().toURL().toString());
        ImageView imageControl = new ImageView(image);

        //Resize the view control
        imageControl.setFitHeight(200);
        imageControl.setFitWidth(200);

        VBox  layout = new VBox();
        layout.getChildren().add(imageControl);

        return new Scene(layout,500,500);
    }


    //Lists - dropdown (ComboBox), ListView
    public Scene createLists(){


        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        //Display into a drop-down list
        ObservableList<String> items = FXCollections.observableArrayList
                ("Newspaper","Friend","Local Ad","Flyer","Internet");

        ComboBox combo = new ComboBox();
        combo.getItems().addAll(items);

        //Display a list
        items = FXCollections.observableArrayList
                ("Swimming","Reading","Watching TV","Movies","Music");

        ListView list = new ListView(items);


        box.getChildren().addAll(combo, list);

        //Lists can support mutiple selections
        //list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println("Selected: "  + newValue);
            }
        });

        return new Scene(box, 300,300);
    }

    //Dialog boxes - Color picker, Date picker
    public Scene createDialogs(){

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.setPadding(new Insets(10));

        ColorPicker colors = new ColorPicker();
        box.getChildren().add(colors);

        colors.valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {

                System.out.println("Color chosen: r =  " + newValue.getRed() + ", g = " + newValue.getGreen()
                        + ", b = " + newValue.getBlue());
            }
        });

        DatePicker dates = new DatePicker();
        box.getChildren().add(dates);

        return new Scene(box,300,330);
    }



}
