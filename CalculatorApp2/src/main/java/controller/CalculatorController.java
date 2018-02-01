package controller;

/*
    Name: Patrick Callahan
    Date: 1/27/2018
    File Name: CalculatorController.java
 */


import javafx.beans.binding.When;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * CalculatorController to hold CalculatorUI logic
 * * @version 2.0
 * @author  Patrick Callahan
 */
public class CalculatorController {

    //Objects and primitives used
    private String inputOperator = " ";
    private String inputNumberAsString = "0";
    private float computedValue = 0;
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
        // Handle button clicks with an EventHandler lambda object
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
                    if (inputNumberAsString.equals("0")){
                        inputNumberAsString = buttonText;
                    } else {
                        inputNumberAsString += buttonText;
                    }
                    numberDisplay.setText(inputNumberAsString);
                    if (inputOperator.equals("Enter")) {
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
                    break;// Clear button
            }
        };
        return buttonClickHandler;
    }

    //Calculate integers
    private void calculateIntegers() {
        float inputNumber = Float.parseFloat(inputNumberAsString);
        inputNumberAsString = "0";
        if (inputOperator.equals(" ")){
            computedValue = inputNumber;
            setColorDisplay();
        }
        if (inputOperator.equals("+")) {
            computedValue += inputNumber;
            setColorDisplay();
        }
        if (inputOperator.equals("-")) {
            computedValue -= inputNumber;
            setColorDisplay();
        }
        if (inputOperator.equals("*")) {
            computedValue *= inputNumber;
            setColorDisplay();
        }
        if (inputOperator.equals("/")) {
            computedValue /= inputNumber;
            setColorDisplay();
        }
        if (inputOperator.equals("Enter")) {
            setColorDisplay();
        }
        numberDisplay.setText(computedValue + " ");
    }

    //When a user clicks an operator change the color of the number display
    private void setColorDisplay(){
        if (inputOperator.equals(" ")){
            numberDisplay.setStyle(" -fx-text-fill: #e3680d;\n" +
                    "    -fx-background-color:#e30d0d;\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;\n" +
                    "    -fx-padding: 5;");
        }
        if (inputOperator.equals("+")) {
            numberDisplay.setStyle(" -fx-text-fill: #e3680d;\n" +
                    "    -fx-background-color:#0c3124;\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;\n" +
                    "    -fx-padding: 5;");
        }
        if (inputOperator.equals("-")) {
            numberDisplay.setStyle(" -fx-text-fill: #71a03a;\n" +
                    "    -fx-background-color:#71383a;\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;\n" +
                    "    -fx-padding: 5;");
        }
        if (inputOperator.equals("*")) {
            numberDisplay.setStyle(" -fx-text-fill: #0c383a;\n" +
                    "    -fx-background-color:#006eff;\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;\n" +
                    "    -fx-padding: 5;");
        }
        if (inputOperator.equals("/")) {
            numberDisplay.setStyle(" -fx-text-fill: #2fe2c8;\n" +
                    "    -fx-background-color:#0c50d7;\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;\n" +
                    "    -fx-padding: 5;");
        }
        if (inputOperator.equals("Enter")) {
            numberDisplay.setStyle(" -fx-text-fill: #2fe2c8;\n" +
                    "    -fx-background-color:#0cc0d7;\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;\n" +
                    "    -fx-padding: 5;");
        }
    }
}
