package controller;

/*
    Name: Patrick Callahan
    Date: 1/27/2018
    File Name: CalculatorController.java
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * CalculatorController to hold CalculatorUI logic
 * * @version 2.0
 * @author  Patrick Callahan
 */
public class CalculatorController {

    //Objects and primitives used
    private float computedValue = 0;
    private String inputNumberAsString = "0";
    private String inputOperator = " ";
    private TextField numberDisplay = new TextField();
    EventHandler buttonClickHandler;

    /**
     * Constructor for controller
     */
    public CalculatorController(){

    }


    /**
     * Method to set display of integers
     *
     * @param display
     * @return numberDisplay
     */
    public TextField setDisplay(TextField display){

       return numberDisplay = display;

    }


    /**
     * An event handler function to handle input from the user to calculate integers
     *
     * @return buttonClickHandler
     */
    public EventHandler buttonClickHandler() {
        // Handle button clicks with and EventHandler lambda object
        buttonClickHandler = event -> {
        String buttonText = ((Button) event.getSource()).getText();
        //Swtich, case to check button pressed
            switch (buttonText) {
                case "0": case "1":
                case "2": case "3":
                case "4": case "5":
                case "6": case "7":
                case "8": case "9":
                    //If button pressed is equal 0 make buttonText equal it
                    if (inputNumberAsString == "0") {
                        inputNumberAsString = buttonText;
                    } else {
                        inputNumberAsString += buttonText;
                    }
                    numberDisplay.setText(inputNumberAsString);
                    if (inputOperator == "Enter") {
                        computedValue = 0;
                        inputOperator = " ";
                    }
                    break;


                case "+":
                    calculateIntegers();
                    inputOperator = "+";
                    break;
                case "-":
                    calculateIntegers();
                    inputOperator = "-";
                    break;
                case "*":
                    calculateIntegers();
                    inputOperator = "*";
                    break;
                case "/":
                    calculateIntegers();
                    inputOperator = "/";
                    break;
                case "Enter":
                    calculateIntegers();
                    inputOperator = "Enter";
                    break;
            }
        };
        return buttonClickHandler;
    }

    //Calculate integers
    private void calculateIntegers() {
        float inputNumber = Float.parseFloat(inputNumberAsString);
        inputNumberAsString = "0";
        if (inputOperator ==  " "){
            computedValue = inputNumber;
        }
        if (inputOperator == "+") {
            computedValue += inputNumber;
        }
        if (inputOperator == "-") {
            computedValue -= inputNumber;
        }
        if (inputOperator == "*") {
            computedValue *= inputNumber;
        }
        if (inputOperator == "/") {
            computedValue /= inputNumber;
        }
        if (inputOperator == "Enter") {

        }
        numberDisplay.setText(computedValue + " ");
    }
}
