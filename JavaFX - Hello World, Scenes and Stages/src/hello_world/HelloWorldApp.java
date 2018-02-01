package hello_world;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorldApp extends Application {


    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World App");
        stage.setScene(getScene());
        stage.show();
    }

    //This will assemble our UI
    private Scene getScene(){

        //Layout to hold controls
        VBox box = new VBox();

        //Centers the child elments of the box
        box.setAlignment(Pos.CENTER);

        //Add padding around the childe elements
        box.setPadding(new Insets(10,10,10,10));

        Text text = new Text("Hello World");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));

        //Add control to the layout, the layout to the scene
        box.getChildren().add(text);

        return new Scene(box, WIDTH, HEIGHT);

    }
}
