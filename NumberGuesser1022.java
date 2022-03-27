package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class NumberGuesser1022 {
   static Scanner c = new Scanner(System.in);
    public static void main(String[] args) {

        //variables to store name level and roundReached
        String name = userName();
        int level=levelSelection();
        int roundReached = game(level);
        //takes name and roundReached and adds use to leaderboard
        leaderboard(name,roundReached);
    }//end of main method

    //for choosing level
    public static int levelSelection(){
        int level;
        System.out.println("Please choose a difficulty\n1 for easy\n2 for medium\n3 for hard");
        do{

            level = c.nextInt();
            if(level > 3 || level < 1){
                System.out.println("Please enter a valid number");
                System.out.println("1 for easy\n2 for medium\n3 for hard");

            }
        }
        while(level > 3 || level < 1);

        //System.out.println(level);
        return level;
    }
    //for getting user's name
    public static String userName(){
        System.out.print("Enter your username: ");
        String name=c.nextLine();
        System.out.println("Welcome "+ name+ "!");
        return name;
    }



    //guessing portion
    public static int game(int level){
        int lives = 3;
        int roundNumber =1;
        int guess, rand;
        int max;
        if (level==1){
            max = 3;
        }
        else if (level == 2){
            max = 5;
        }
        else {
            max = 10;
        }

        while(lives>0){
            System.out.print("Guess a number between 1 and "+ max+": ");
            guess = c.nextInt();
            rand = (int)(Math.random()*(max)+1);
            System.out.println("random number is "+rand);//test

            if (guess!=rand){
                lives--;
                while(guess != rand && lives > 0){
                    if(guess>rand){
                        System.out.println("Try guessing lower!");
                    }
                    else {
                        System.out.println("Try guessing higher!");
                    }
                    guess=c.nextInt();
                    if (guess!=rand){
                        lives--;
                    }
                }
            }//end of if
            if(lives>0){
                System.out.println("That is Correct");
                roundNumber++;
            }
        }//end of lives loop

        System.out.println("You reached round number "+roundNumber);
        return roundNumber;
    }//end of game method


    public static void leaderboard(String name, int roundReached){
        Integer round = roundReached;
        round.toString();
        try {
            File myObj = new File("leaderboard.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




        try {
            FileWriter myWriter = new FileWriter("leaderboard.txt",true);
            myWriter.write("\n"+name+":\t"+String.format("%d",roundReached));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//end of leaderboard method


}//end of NumberGuesser1022
