package myLib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.IO.println;

public class UserMethods {
    public void myPrinter(String message){
        println(message);
    }

    public Integer requestInteger(String message){
        boolean integerOK = false;
        Integer integerUser = 0;
        Scanner sc = new Scanner(System.in);
        myPrinter(message);
        while(!integerOK) {
            try {
                integerUser = sc.nextInt();
                integerOK = true;
            } catch (InputMismatchException e) {
                myPrinter("Wrong integer. \nIntroduce an integer:");
                sc = null;
                sc = new Scanner(System.in);
            }
        }
        return integerUser;
    }
    public Path requestPath(String message){
        boolean pathOK = false;
        Path pathUser = Path.of("");
        Scanner sc = new Scanner(System.in);
        myPrinter(message);
        while(!pathOK) {
            if (Files.exists(pathUser)) {
                    pathUser = Path.of(sc.nextLine());
                    if(Files.isReadable(pathUser)) {
                        pathOK = true;
                    }else{
                        myPrinter("Permission denied to access the file.");
                    }
            }else{
                myPrinter("Wrong path. The file does not exist.");
            }
        }
        return pathUser;
    }
}
