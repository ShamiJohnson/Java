package com.Shami;

public class Main {

    public static void main(String[] args) {
        int value = 1;
        if(value==1){ System.out.println(value); }


        int switchValue = 3;

        switch (switchValue){
            case 1:
                System.out.println("value was: " + switchValue);
                break;
            case 2:
                System.out.println("value was= " + switchValue);
                break;
                default:
                    System.out.println("the number is: "+ switchValue);
        }

        char charSwitch = 'D';

        switch (charSwitch){
            case 'A':
                System.out.println("value is: "+charSwitch);
                break;
            case 'B':
                System.out.println("value is: "+charSwitch);
                break;
            case 'C':
                System.out.println("value is: "+charSwitch);
                break;
            case 'D':
                System.out.println("value is: "+charSwitch);
                break;
            case 'E':
                System.out.println("value is: "+charSwitch);
                break;
                default:
                    System.out.println("nothing was there");
                    break;

        }


    }
}
