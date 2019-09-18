package com.Shami;

public class Main {

    public static void main(String[] args) {


        calculateScore(true, 800, 5, 100);


        calculateScore(true, 10000,8,200);



        int highScorePosition = calculateHighScorePosition(1500);
        diplayHighScorePosition("Shami", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        diplayHighScorePosition("bob", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        diplayHighScorePosition("Percy", highScorePosition);

        highScorePosition = calculateHighScorePosition(50);
        diplayHighScorePosition("gilbert", highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        diplayHighScorePosition("bugFixed", highScorePosition);


    }





    public static void diplayHighScorePosition(String playerName, int highScorePosition){
        System.out.println("playerName: "+playerName+" _____ highScorePosition: "+highScorePosition);

    }
public static int calculateHighScorePosition(int playerScore){
//        if (playerScore>=1000) {
//            return 1;
//    }else if (playerScore>=500){
//            return 2;
//    }else if (playerScore>=100){
//            return 3;
//    }
//            return 4;

        int position = 4;
        if (playerScore >= 1000){
            position=1;
        }else if(playerScore >=500){
            position=2;
        }else if (playerScore >= 100){
            position=3;
        }
            return position;

}










    public static int calculateScore(boolean gameOver,int score, int levelCompleted, int bonus ){


        if (gameOver==true){
            int finalScore = score +(levelCompleted * bonus);
            finalScore +=2000;
            System.out.println("your final score is: " + finalScore);
            return finalScore;
        }else {
            return -1;
        }


    }


































}
