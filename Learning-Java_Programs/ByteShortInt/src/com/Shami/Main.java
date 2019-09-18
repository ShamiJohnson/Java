package com.Shami;

public class Main {

    public static void main(String[] args) {

        byte mybyte = 12;
        short myshort = 12;
        int myint = 12;
        long mylong = 50000 + 10*(mybyte+myshort+myint);
        System.out.println(mylong);








/*
	    // int has a width of 32
        int myMinValue = -2_147_483_648;
        int myMaxValue = -2_147_483_648;
        int myTotal = (myMinValue/2);
        System.out.println("myTotal = " + myTotal);

        // byte has a width 8
        byte myByteValue = -128;
        byte myNewByteValue = (byte) (myByteValue/2);
        System.out.println("myNewByteValue = " + myNewByteValue);

        //short has width of 16
        short myShortValue = 32767;
        short myNewShortValue = (short) (myShortValue/2);
        System.out.println("myNewShortValue = " + myNewShortValue);
        //long has width 64
        long myLongValue = 9_223_372_036_854_775_87L;
        */

    }
}