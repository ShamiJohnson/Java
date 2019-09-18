package com.Shami;

public class Main {

    public static void main(String[] args) {
        int result = 1+2;
        System.out.println(result);

        result = result -1;
        System.out.println(result);

        result = result *10;
        System.out.println(result);

        result = result /5;
        System.out.println(result);

        result = result %3;
        System.out.println(result);

        result++;
        System.out.println(result);

        result *= 10;
        System.out.println(result);

        result -= 10;
        System.out.println(result);

        boolean isAliean = false;
        if (isAliean == false){
            System.out.println("not an aliean");
        }
        else {
            System.out.println("an alien ");
        }

        int topScore = 100;
        if (topScore==100){
            System.out.println("it is 100");
        }

        boolean isCar = false;

        boolean wasCar= isCar ? true : false;

        if (wasCar=true){
            System.out.println("was Car true");
        }
        else if (wasCar=false){
            System.out.println("wasCar false");
        }

    }
}
