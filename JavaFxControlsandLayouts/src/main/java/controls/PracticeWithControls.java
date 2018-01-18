package controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;


public class PracticeWithControls extends Application {

    private Stage stage;


    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;

        stage.setTitle("Practing with controls and layouts");

        stage.show();

    }

    public void useImages() throws MalformedURLException{
        //Image image = new Image(new File("img/football.jpeg").toURI().toURL().toString());
        ImageView view;
    }

    public void useButtons(){

        HBox hBox = new HBox();

        Button previous = new Button();
        Button next = new Button();

        hBox.getChildren().addAll(previous, next);


        stage.setScene(new Scene(hBox,500,500));
    }


    public void useTextControls(){

    }


    public void useCheckBoxesAndRadio(){

    }

    public void useLists(){

    }

    public void useDailogs(){


    }
}
