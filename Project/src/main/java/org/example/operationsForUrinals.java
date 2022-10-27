package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class operationsForUrinals {

    static Scanner sc = new Scanner(System.in);
    public static void getString(int choice) throws FileNotFoundException {
        if(choice == 0){
            System.out.println("Enter  the string : ");
            String str = sc.next();
            if(isValidString(str)){
                countMaximumAvailableUrinals(str);
            }
            else{
                System.out.println("Invalid string entered");
            }
        }else{
            readFromFile();
        }
    }

    public static boolean isValidString(String str){
        boolean isValidInput = true;
        char[] chars = str.toCharArray();
        System.out.println ("Not yet implemented");
        return isValidInput;
    }

    public static void readFromFile() throws FileNotFoundException {
        File file = new File("Project/src/main/resources/urinal.dat");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            countMaximumAvailableUrinals(sc.nextLine());
        }
    }

    public static void countMaximumAvailableUrinals(String str){

    }
}
