package com.Shami;

public class Main {

    public static void main(String[] args) {
        calcFeetAndInchesToCentimeters(10,1);
       calcFeetAndInchesToCentimeters(100);

    }


    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet>=0){
            if(inches>=0 && inches<=12){//calculate it here
                double centimeters= (feet * 12) *2.54;
                System.out.println(feet+" feet "+ inches+" inches = "+centimeters+ " cm");
            }
        }else{
            System.out.println("something went wrong");
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
//        if (inches >=0){//you can put your code here since it is checking it
//        }
//        return -1;

        //new way of checking with the if statement.
        if (inches<0){
            System.out.println("something went wrong :( ");
            return -1;
        }
        double feet = (int) inches/12;
        double remaininginches = (int) inches %12;
        System.out.println(inches+" inches is equal to "+ feet + " feet and "+ remaininginches+"inches");
        return calcFeetAndInchesToCentimeters(feet,remaininginches);

    }








//        int print = calculateScore("shami",500);
//        System.out.println("new score is " +print);
//        calculateScore(75);
//        calculateScore();
//    }

//
//    public static int calculateScore(String playerName, int score){
//        System.out.println("player: "+playerName+" scored: "+ score +" points");
//        return score * 1000;
//    }
//
//
//

//    public static int calculateScore(int score){
//        System.out.println("unamed player scored: "+ score +" points");
//        return score * 1000;
//    }
//
//
//
//    public static int calculateScore(){
//        System.out.println("no player and no score");
//        return 0;
//    }
//
//
//    public static void calculateScore(){
//        System.out.println("no player and no score");
//
//
//



}
