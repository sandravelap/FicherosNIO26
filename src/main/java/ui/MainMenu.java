package ui;

import myLib.UserMethods;

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
                String pathString = "src/main/resources/test2.txt";
                Path p = Path.of(pathString);
                if (Files.exists(p)){
                    ArrayList<String> pTextContent = null;
                    try {
                        pTextContent = new ArrayList<>(Files.readAllLines(p));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    for (String line : pTextContent){
                        userMethods1.myPrinter(line);
                    }
                }else{
                    userMethods1.myPrinter("The file does not exist.");
                }

            }
            case "2" -> {
                userMethods.myPrinter("option2");
            }
            default -> userMethods.myPrinter("Wrong option.");
        }
    }
}
