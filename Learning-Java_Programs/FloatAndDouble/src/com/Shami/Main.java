package com.Shami;

public class Main {

    public static void main(String[] args) {

        int myIntVal = 5/3;
        float myFloat = 5f/3f;
        double myDouble = 5d/3d;

        System.out.println("int val: " + myIntVal);
        System.out.println("float val: " + myFloat);
        System.out.println("double val: " + myDouble);

        double poundToConvert = 200d;
        double kilogram = poundToConvert * 0.45359237d ;
        System.out.println("kilogram: " + kilogram);
    }
}
