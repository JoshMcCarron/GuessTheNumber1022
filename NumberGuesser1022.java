package com.company;

public class NumberGuesser1022 {

    public static void main(String[] args) {
        String name = userName();
        int level=levelSelection();

        if (level==1){
            levelOne();
        }
        else if (level==2){
            levelTwo();
        }
        else{
            levelThree();
        }
        // write your code here
    }

    //for choosing level
    public static int levelSelection(){
        int level=-1;
        return level;
    }
    //for getting user's name
    public static String userName(){
        String name="";
        return name;
    }



    //level 1
    public static void levelOne(){

    }
    //level 2
    public static void levelTwo(){

    }
    //level 3
    public static void levelThree(){

    }

    public static void leaderboard(){

    }


}
