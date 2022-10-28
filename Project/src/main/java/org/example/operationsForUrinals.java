package org.example;

import java.io.*;
import java.util.Scanner;

public class operationsForUrinals {

    static Scanner sc = new Scanner(System.in);
    public static int personChoice;

    public static void getString(int choice) throws IOException {
        personChoice = choice;
        if (choice == 0) {
            System.out.println("Enter the string OR -1 for exit: ");
            String str;
            do{
                str = sc.next();
                if(!str.equals("-1")) {
                    if (isValidString(str)) {
                        System.out.println(countMaximumAvailableUrinals(str));
                    } else {
                        System.out.println("-1");
                    }
                }

            } while(!str.equals("-1"));

            System.out.println("Exited the code successfully");
        }
        else {
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
        String pathName = "";
        String st;
        if((st = br.readLine()) == null){
            System.out.println("Input file is empty");
        }
        else{
            pathName = setPathNameToWriteFile();
            int res;

            FileWriter myWriter = new FileWriter(pathName, true);
            while ((st = br.readLine()) != null){
                res = -1;
                if (isValidString(st)) {
                    res = countMaximumAvailableUrinals(st);
                }

                System.out.println(res);
                myWriter.write(res + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }

    }

    public static String setPathNameToWriteFile() throws IOException {
        int count = 0;
        String pathName = "src\\main\\resources\\rule.txt";
        do {
            File myObj = new File(pathName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                count = 0;
            } else {
                if(count == 0){
                    System.out.println("rule.txt file already exists.");
                }
                else{
                    System.out.println("rule"+Integer.toString(count)+".txt file already exists.");
                }
                count += 1;
                pathName = "src\\main\\resources\\rule"+Integer.toString(count)+".txt";
            }
        } while(count > 0);

        return pathName;
    }


    public static int countMaximumAvailableUrinals(String str){
        int result;
        char[] chars = str.toCharArray();
        int charArrayLength = chars.length;

        // code for counting maximun number of urinals
        int changesValues = 0;
        for(int i=0; i<charArrayLength; i++){
            if(i == 0) {
                /*
                 * checking for the first character of the string
                 * if the length is 1 only then, we do the operations and break the loop
                 * else we check if the first character is 0 or not
                 */
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
                /*
                 * checking for the last and second last character
                 */
                if (chars[i - 1] == '0' && chars[i] == '0') {
                    chars[i] = '1';
                    changesValues += 1;
                }
            }
            else {
                /*
                 * checking the rest of the characters
                 * by checking its previous and next characters
                 */
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
