package enctyption_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class EncryptionPractice {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);


        //Prompt for a user name
        System.out.println("Username: ");
        String userName = console.nextLine();

        System.out.println("Password: ");
        String password = console.nextLine();

        //Ecrypt the password
        BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();
        password = encryptor.encryptPassword(password);


        //Show the user
        System.out.println("Encrypted Password: " + password);

        System.out.println("Confirm password: ");
        String confirm = console.nextLine();

        if (encryptor.checkPassword(confirm, password)) {

            System.out.println("Password was regonized");
        }
        else {
            System.out.println("Password was not recgonized");
        }

        String message = "hello world";

        /*
        switch (message){
            case "hello world":
                break;
            case "Hello world":
                break;
        }

        try(Scanner fileReader = new Scanner(new FileInputStream("text.txt"))){

        }
        catch (FileNotFoundException e){

        }*/

    }
}
