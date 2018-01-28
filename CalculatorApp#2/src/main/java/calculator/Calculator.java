package calculator;

import javafx.application.Application;
import javafx.stage.Stage;


public class Calculator {

    private long firstNumber;
    private long secondNumber;



    public Calculator(){
    }

    public long add(long firstNumber, long secondNumber){

        return firstNumber + secondNumber;
    }

    public long subtract(long firstNumber, long secondNumber){

        return firstNumber - secondNumber;
    }


    public long divide(long numerator, long denominator){

        while(numerator == 0) {
            System.out.println("Cant divide by 0");
            break;
        }
        return numerator / denominator;
    }


    public long multiply(long firstNumber, long secondNumber){

       return firstNumber * secondNumber;
    }


    /**
     * instance of controller in view, instance of model in controller
     * Event Handlers in view
     * Operands and operators in model
     *
     *
     * @param args
     */




    public static void main(String[] args) {

        Calculator newOne = new Calculator();


        System.out.println("Your output is: " + newOne.divide(10,10));


    }

}
