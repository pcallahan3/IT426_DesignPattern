package layouts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import  javafx.scene.text.Text;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Optional;

public class PracticeWithControls extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Practicing with layouts");
        stage.setScene(useBorderPane());
        stage.show();

    }

    //GridPane - rows & cols
    public Scene useGridPane(){


        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10));

        //Create a 3 column layout
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(100));

        //Create some controls
        RadioButton button1 = new RadioButton("Option 1");
        RadioButton button2 = new RadioButton("Option 2");
        RadioButton button3 = new RadioButton("Option 3");

        button1.setMaxWidth(90);
        button2.setMaxWidth(90);
        button3.setMaxWidth(90);



        ToggleGroup group = new ToggleGroup();
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);


        Button button = new Button("Please click here");
        button.setPrefWidth(200);

        TextArea area = new TextArea();
        Text banner = new Text("Lots of intresting info located here here here here");
        banner.setWrappingWidth(80);
        banner.setTextAlignment(TextAlignment.CENTER);

        //Arrange them
        grid.add(button1, 0,0);
        grid.add(button2, 1,0);
        grid.add(button3, 2,0);

        grid.add(button, 0,1,3,1);

        grid.add(area, 0,2,2,1);
        grid.add(banner,0,2,1,1);

        return new Scene(grid,300,300);
    }


    //StackPane - place elements on top of each other
    public Scene useStackPane(){

        StackPane pane = new StackPane();

        //Create a few controls
        Circle circle1 = new Circle(170);
        Circle circle2 = new Circle(70);
        Circle circle3 = new Circle(120);

        circle1.setFill(Color.ANTIQUEWHITE);
        circle2.setFill(Color.ALICEBLUE);
        circle3.setFill(Color.ORANGE);

        //Add the controls to the layout
        pane.getChildren().addAll(circle1, circle2, circle3);

        //You can place complex controls over other controls
        Button button = new Button("Click me");
        pane.getChildren().add(button);

        //Move elements on the stackpane
        StackPane.setAlignment(circle1, Pos.TOP_RIGHT);
        StackPane.setAlignment(circle2, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(circle3, Pos.BOTTOM_LEFT);



        return new Scene(pane, 300, 300);
    }


    //BorderPane - place elements in regions - north, south, east, west, and center
    public Scene useBorderPane()  {

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        //North
        HBox northPanel = new HBox();
        northPanel.setAlignment(Pos.CENTER);
        northPanel.setSpacing(10);
        northPanel.getChildren().addAll(new Button("Please"),new Button("click"),
                new Button("here"),new Button("now"),new Button("!"));

        pane.setTop(northPanel);

        //South
        Label lotsOfText = new Label("LLLLLLLLLLLLDFDFDFDFDFDDDDDDDDDDDDDDDD" +
                "DDDDDFDFDFDFDFDFDFDSDFDSFDS");
        lotsOfText.setWrapText(true);
        pane.setBottom(lotsOfText);

        //East
        VBox eastPanel = new VBox();
        eastPanel.setAlignment(Pos.CENTER);
        eastPanel.setSpacing(10);
        eastPanel.setPadding(new Insets(10));

        //Display into a drop-down list
        ObservableList<String> items = FXCollections.observableArrayList
                ("Swimming","Reading","Watching TV","Movies","Music");

        ListView list = new ListView(items);


        eastPanel.getChildren().addAll(list);
        pane.setRight(eastPanel);

        //West
        VBox westPanel = new VBox();
        westPanel.setAlignment(Pos.CENTER);
        westPanel.setPadding(new Insets(10));
        westPanel.setSpacing(10);

        //Create several options
        String[] choices = {"Blue", "Purple", "Pink", "White"};
        CheckBox[] checkBoxes = new CheckBox[choices.length];

        for(int i = 0; i < choices.length; i++){

            CheckBox checkBox = new CheckBox(choices[i]);
            checkBox.setPrefWidth(100);
            checkBox.setAlignment(Pos.CENTER_LEFT);

            checkBoxes[i] = checkBox;
            westPanel.getChildren().add(checkBox);
        }

        pane.setLeft(westPanel);

        //Center
        Image image = null;
        try {
            image = new Image(new File("images/Desert.jpg")
                    .toURI().toURL().toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ImageView imageControl = new ImageView(image);

        //Resize the view control
        //imageControl.setFitHeight(200);
        //imageControl.setFitWidth(200);
        pane.setCenter(imageControl);



        return new Scene(pane, 600, 600);
    }

    //Others - FlowPane, TilePane, AnchorPane
}

