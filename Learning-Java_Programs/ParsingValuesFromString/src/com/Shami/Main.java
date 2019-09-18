package com.Shami;

public class Main {

    public static void main(String[] args) {
        String numberAsString = "2019.125";
        System.out.println("numberAsString: "+numberAsString);

        double number = Double.parseDouble(numberAsString);
        //number=number+number;
        System.out.println(number);
        numberAsString +=1;
        number +=1;

        System.out.println(numberAsString);
        System.out.println(number);
    }
}
