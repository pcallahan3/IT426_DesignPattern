package scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;



public class StoryBook extends Application {

    public static final int SPACING = 10;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    //Save our stage
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        //Prepare the window
        stage.setTitle("Working with scenes");
        stage.setScene(getWaitingScene());
        stage.show();

        //We are going to wait on the current  screen using
        //animation (key frame)
        KeyFrame frame = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(getStoryScene1());

            }
        });

        Timeline wait = new Timeline(frame);
        wait.play();

    }


    private Scene getWaitingScene(){

        //Create a layout
        VBox waitingLayout = new VBox();

        ///Center child elements
        waitingLayout.setAlignment(Pos.CENTER);
        //Space between child elements and edge of layout
        waitingLayout.setPadding(new Insets(10));

        //Space between child elements
        waitingLayout.setSpacing(SPACING);

        Button button = new Button("Click me");

        //Add a few elements
        ProgressIndicator progressIndicator = new ProgressIndicator();
        Text waitingMessage = new Text("Please wait...");
        waitingMessage.setFont(Font.font("Gar", FontWeight.BOLD,30));

        waitingLayout.getChildren().add(progressIndicator);
        waitingLayout.getChildren().add(waitingMessage);



        //Generate scence based on layout
        return new Scene(waitingLayout, WIDTH, HEIGHT);
    }

    private Scene getStoryScene1(){

        //Create a layout
        VBox waitingLayout = new VBox();

        ///Center child elements
        waitingLayout.setAlignment(Pos.CENTER);
        //Space between child elements and edge of layout
        waitingLayout.setPadding(new Insets(10));

        //Space between child elements
        waitingLayout.setSpacing(SPACING);



        //Add a few elements

        Text waitingMessage = new Text("Hello world");
        Button btn = new Button();
        btn.setMaxSize(50,50);
        btn.setText("Ok");


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


        waitingLayout.getChildren().add(waitingMessage);
        waitingLayout.getChildren().add(btn);



        //Generate scence based on layout
        return new Scene(waitingLayout, WIDTH, HEIGHT);
    }
}
