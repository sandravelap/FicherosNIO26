package ui;

import models.Writing;
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

    public void showMenu(){
        UserMethods userMethods = new UserMethods();
        do{
            userMethods.myPrinter("Choose an option: ");
            userMethods.myPrinter("1. Read file");
            userMethods.myPrinter("2. Write file (add info to existing file");
            userMethods.myPrinter("3. Create file");
            userMethods.myPrinter("5. Copy file");
            userMethods.myPrinter("0. Salir");
            processOption(requestOption());
        }while(!exitMenu);
    }
    private String requestOption(){
        return this.scanner.nextLine();
    }

    private void processOption(String option){
        UserMethods userMethods = new UserMethods();
        switch(option){
            case "0" -> exitMenu = true;
            case "1" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to read: ");
                FileServices fileServices =  new FileServices();
                try {
                    for (String line : fileServices.readTextFile(p)) {
                        userMethods.myPrinter(line);
                    }
                } catch (IOException e) {
                    userMethods.myPrinter("Something went wrong.");
                }
            }
            case "2" -> {
                Writing writing = new Writing();
                writing.setP(userMethods.fileToRead("Introduce the path to the file to write: "));
                writing.setText(userMethods.requestString("Introduce the text to append to the file: "));
                FileServices fileServices =  new FileServices();
                try {
                    fileServices.writeFile(writing);
                } catch (IOException e) {
                    userMethods.myPrinter("Something went wrong.");
                }
            }
            case "3" -> {
                String fNameToCreate = userMethods.requestStringRegex("Introduce the name of the file: ", "^(?!(?:CON|PRN|AUX|NUL|COM[1-9]|LPT[1-9])(?:\\..*)?$)[^\\\\/:*?\"<>|\\r\\n\\s](?:[^\\\\/:*?\"<>|\\r\\n]*[^\\\\/:*?\"<>|\\r\\n\\s])?$");
                FileServices fileServices = new FileServices();
                try {
                    fileServices.fileToCreate(fNameToCreate);
                } catch (IOException e) {
                    userMethods.myPrinter("Something went wrong. ");
                }
            }
            case "5" -> {
                Path p = userMethods.fileToRead("Introduce the path to the file to copy: ");
                FileServices fileServices =  new FileServices();
                try {
                    fileServices.copyFile(p);
                } catch (IOException e) {
                    userMethods.myPrinter("Something went wrong. ");
                }
            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
