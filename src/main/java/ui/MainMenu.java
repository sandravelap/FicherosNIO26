package ui;

import myLib.UserMethods;
import services.FileServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private boolean exitMenu = false;
    UserMethods userMethods = new UserMethods();
    public void showMenu(){
        do{
            userMethods.myPrinter("Choose an option: ");
            userMethods.myPrinter("1. Read file");
            userMethods.myPrinter("2. Create file or directory");
            userMethods.myPrinter("0. Salir");
            processOption(requestOption());
        }while(!exitMenu);
    }
    private String requestOption(){
        return this.scanner.nextLine();
    }

    private void processOption(String option){
        switch(option){
            case "0" -> exitMenu = true;
            case "1" -> {
                UserMethods userMethods1 = new UserMethods();
                Path p = userMethods1.fileToRead("Introduce the path to the file to read: ");
                FileServices fileServices =  new FileServices();
                try {
                    for (String line : fileServices.readTextFile(p)) {
                        userMethods1.myPrinter(line);
                    }
                } catch (IOException e) {
                    userMethods1.myPrinter("Something went wrong.");
                }
            }
            case "2" -> {
                userMethods.myPrinter("option2");
            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
