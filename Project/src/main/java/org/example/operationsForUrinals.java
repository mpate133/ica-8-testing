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
                countMaximumAvailableUrinals(str);
            } else {
                System.out.println("-1");
            }
        } else {
            readFromFile();
        }
    }

    public static boolean isValidString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c, map.get(c) + 1);
        }

        if(chars.length > 0 && map.size() < 3 && ((map.size() == 1 && (map.containsKey('0') || map.containsKey('1'))) || (map.size() == 2 && map.containsKey('0') && map.containsKey('1'))) ){
            return true;
        }
        else{
            return false;
        }
    }

    public static void readFromFile() throws IOException {
        File file = new File("src\\main\\resources\\urinal.dat");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){
            if (isValidString(st)) {
                countMaximumAvailableUrinals(st);
            } else {
                System.out.println("-1");
            }
        }
    }

    public static void countMaximumAvailableUrinals(String str){
        int result = -1;
        boolean flag = true;
        char[] chars = str.toCharArray();
        int charArrayLength = chars.length;
        for(int i=0; i<chars.length-1; i++){
            if((chars[i] != '1' && chars[i] != '0') || (chars[i] == '1' && chars[i] == chars[i+1])){
                flag = false;
                break;
            }
        }

        if(flag){
            // code for counting maximun number of urinals
            int changesValues = 0;
            for(int i=0; i<charArrayLength; i++){
                if(i == 0) {
                    if(charArrayLength== 1){
                        result = 1 - Character.getNumericValue(chars[0]);
                        break;
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
        }

        if(personChoice == 0){
            System.out.println(result);
        }
        else{
          // write in the file
        }
    }
}
