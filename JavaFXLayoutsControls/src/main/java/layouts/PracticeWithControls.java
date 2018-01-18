package layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import  javafx.scene.text.Text;
import java.util.Optional;

public class PracticeWithControls extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Practicing with layouts");
        stage.setScene(useStackPane());
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
    public Scene useBorderPane(){

        return null;//new Scene();
    }

    //Others - FlowPane, TilePane, AnchorPane
}
