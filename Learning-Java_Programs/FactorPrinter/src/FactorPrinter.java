public class FactorPrinter {
    public static void printFactors(int number){

        if (number<1) {
            System.out.println("Invalid Value");
        }

        int factorNumber = 0;

        while (factorNumber<=number){
            factorNumber++;
            if ((number%factorNumber) == 0){
                System.out.println(factorNumber );
            }
        }
    }
}

