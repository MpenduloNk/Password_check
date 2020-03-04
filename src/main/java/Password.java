import java.lang.*;
import java.util.Locale;
import java.util.Scanner;

public class Password {

    public static String password_is_valid(String password){
        Boolean len = false;
        Boolean upper = false;
        Boolean lower = false;
        Boolean digit = false;
        Boolean specialX = false;
        String message = " ";
        int n = 0;

        for (int i = 0; i < password.length(); i++ ){
            if ( password.length() >= 8 && password.length() <= 15) {
                len = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                upper = true;
            }
            if (Character.isLowerCase(password.charAt(i))){
                lower = true;
            }
            if (Character.isDigit(password.charAt(i))){
                digit = true;
            }
            if(password.matches("(?=.*[~!@#$%^&*()_+]).*")){
                specialX = true;
            }
        }

        if (password.length() >= 8 && password.length() <= 15 && upper && lower  && digit  && specialX ){
            message = "Password Successfully";
        }
        else {
            message += "\nSORRY!!! PLEASE TRY AGAIN ONCE MORE: The following is missing";
            if(!len){
                message += "\npassword should be longer than than 8 characters";
            }
            if (!upper) {
                message += "\npassword should have at least one uppercase letter";
            }else{n = n + 1;}

            if (!lower){
                message += "\npassword should have at least one lowercase letter";
            }else{n = n + 1;}
            if (!digit){
                message += "\npassword should at least have one digit";
            }else{n = n + 1;}
            if (!specialX){
                message += "\npassword should have at least one special character";
            }else{n = n + 1;}

        }
        if (n == 3){
            message = "Password is OK!!";
        }
        return message;
    }

    public static void main(String[] args){

        String strPassword = " ";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please provide the combination of your password: ");
            strPassword = scanner.next();

            System.out.println(password_is_valid(strPassword));
            if (password_is_valid(strPassword).equals("Password is OK!!")){
                System.out.println("But a password should have at least one special character/digit/upper/lower though");
                break;
            }
            System.out.println(" ");

        }while (!password_is_valid(strPassword).equals("Password Successfully"));

    }
}
