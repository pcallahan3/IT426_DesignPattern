package launch;

/*
    Name: Patrick Callahan
    Date: 1/23/2018
    File Name: Launcher.java
 */

import javafx.application.Application;
import ui.CalculatorUI;

/**
 *   Launch class to launch CalculatorUI
 *
 * @version 1.0
 * @author  Patrick Callahan
 *
 */
public class Launcher {

     /**
     *
     * Entry point into application
     *
     * @param args Launch CalculatorUI class
     */
    public static void main(String[] args) {
        Application.launch(CalculatorUI.class, args);
    }

}
