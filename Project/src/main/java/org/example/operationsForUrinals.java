package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class operationsForUrinals {

    static Scanner sc = new Scanner(System.in);
    public static int personChoice;

    public static void getString(int choice) throws IOException {
        personChoice = choice;
        if (choice == 0) {
            System.out.println("Enter  the string : ");
            String str = sc.next();
            if (isValidString(str)) {
                System.out.println(countMaximumAvailableUrinals(str));
            } else {
                System.out.println("-1");
            }
        } else {
            readFromFile();
        }
    }

    public static boolean isValidString(String str) {
        char[] chars = str.toCharArray();

        for(int i=0; i<chars.length-1; i++){
            if((chars[i] != '1' && chars[i] != '0') || (chars[i] == '1' && chars[i] == chars[i+1])){
                return false;
            }
        }

        return true;
    }

    public static void readFromFile() throws IOException {
        File file = new File("src\\main\\resources\\urinal.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int res;
        String st;
        while ((st = br.readLine()) != null){
            res = -1;
            if (isValidString(st)) {
                res = countMaximumAvailableUrinals(st);
            }

            // write in file
        }
    }

    public static int countMaximumAvailableUrinals(String str){
        int result = -1;
        char[] chars = str.toCharArray();
        int charArrayLength = chars.length;

        // code for counting maximun number of urinals
        int changesValues = 0;
        for(int i=0; i<charArrayLength; i++){
            if(i == 0) {
                if(charArrayLength== 1){
                    result = 1 - Character.getNumericValue(chars[0]);
                    return result;
                }
                else if(chars[i] =='0' && chars[i+1] == '0'){
                    chars[i] = '1';
                    changesValues += 1;
                }
            }
            else if(i == charArrayLength-1) {
                if (chars[i - 1] == '0' && chars[i] == '0') {
                    chars[i] = '1';
                    changesValues += 1;
                }
            }
            else {
                if (chars[i - 1] == '0' && chars[i] == '0' && chars[i + 1] == '0') {
                    chars[i] = '1';
                    changesValues += 1;
                }
            }
        }
        result = changesValues;
        return result;

    }
}
