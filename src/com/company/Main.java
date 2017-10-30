package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> myMap = new HashMap<>();


        Scanner keyboard = new Scanner(System.in);
        int userInputInt;
        String userInputString;
        String answer = "";
        myMap.put(10, "Ten");
        myMap.put(20, "Twenty");
        myMap.put(30, "Thirty");
        myMap.put(40, "Fourty");
        myMap.put(50, "Fifty");
        myMap.put(60, "Sixty");
        myMap.put(70, "Seventy");
        myMap.put(80, "Eighty");
        myMap.put(90, "ninety");
        myMap.put(100, "One Hundred");


        do {
            System.out.println("Enter a number: ");
            userInputInt = keyboard.nextInt();
            if (!myMap.containsKey(userInputInt)) {
                keyboard.nextLine();
                System.out.println("Inexistant! Type the number to add to the map: ");
                userInputString = keyboard.nextLine();
                myMap.put(userInputInt, userInputString);
                String value = myMap.get(userInputInt);
                System.out.println("You entered: " + value);
            } else {
                System.out.println("You entered: " + myMap.get(userInputInt));
                keyboard.nextLine();

            }
            System.out.println("Do you want to enter another number? (Y/N) ");
            answer = keyboard.nextLine();
        } while (answer.equalsIgnoreCase("y"));

        System.out.println();
        for (Integer key : myMap.keySet()) {

            System.out.println(key + "  ===> "+myMap.get(key));

        }

    // Writing to a file
        String filename = (System.getProperty("user.dir")+ File.pathSeparatorChar + "hashmapFile.txt");
        System.out.println(filename);
        PrintWriter writer = null;

        try {
            writer = new PrintWriter (new File (filename));
        }catch (FileNotFoundException e){
            System.out.println("File does not exist! ");
        }

        for (Integer key : myMap.keySet()){
            System.out.println("writing into a file.... : "+ key);
            writer.println(key + "\t" + myMap.get(key));
        }
        writer.close();


        // Read from a file
        System.out.println();
        System.out.println("Reading from a file .....: ");
        System.out.println();
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line !=null){
                String [] key_value_pair = line.split("\t");
                System.out.println(key_value_pair[0]+ "  :  " + key_value_pair[1]);
                //The key is in key_value_pair[0] and the value is in key_value_pair[1]
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            System.out.println("File does not exist");
        }finally {

        }
    }
}