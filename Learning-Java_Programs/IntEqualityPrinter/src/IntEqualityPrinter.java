public class IntEqualityPrinter {
    public static void printEqual(int first, int second, int third){
        if((first | second | third)<0){
            System.out.println("Invalid Value");
        }
        else if((first == second) && (second == third) && (first == third)){
            System.out.println("All numbers are equal");
        }
        else if((first != second) && (second != third) && (first != third)){
            System.out.println("All numbers are different");
        } else{
            System.out.println("Neither all are equal or different");
        }

    }
}



//* printEqual(1, 1, 1); should print text All numbers are equal
//
//        * printEqual(1, 1, 2); should print text Neither all are equal or different
//
//        * printEqual(-1, -1, -1); should print text Invalid Value
//
//        * printEqual(1, 2, 3); should print text All numbers are different