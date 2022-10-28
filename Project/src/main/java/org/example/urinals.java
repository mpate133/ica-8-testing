package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class urinals {

    /*
     * Author - Manan Hasmukhkumar Patel (mpate133)
     */

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select your choice:");
        System.out.println("0 for Keyboard Input");
        System.out.println("1 for File Input");

        int choice = sc.nextInt();

        if(choice == 1 || choice == 0){
            operationsForUrinals.getString(choice);
        }
        else{
            System.out.println("Code ended due to invalid choice");
        }

    }
}
