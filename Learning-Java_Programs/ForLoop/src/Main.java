public class Main {
    public static void main(String[] args) {
        System.out.println(        ForLoop.calculateInterest(10000.0,2.0));

        for(int i=0; i<5; i++){
            System.out.println("Loop"+ i );
        }

        for(double i=2; i<9; i++){
            System.out.println(  i +  "% = " +  String.format("%.2f", ForLoop.calculateInterest(10000.0,i)));
        }

        System.out.println("\n new loop \n");

        for(double i=8; i>1; i--){
            System.out.println(  i +  "% = " +  String.format("%.2f", ForLoop.calculateInterest(10000.0,i)));
        }

        System.out.println("\n ******* NEW ******* \n\n ");



        int startingNumber=10;
        int willCheckUpto = 50;
        int printNumberLimit=3;
        int count = 0;


        for (int i=startingNumber; i<willCheckUpto; i++){
            if(ForLoop.isPrime(i)){
                count++;
                System.out.println("Number " +i+ " is a prime number! ");
                if(count==printNumberLimit){
                    System.out.println("\nreached "+printNumberLimit+ " numbers! Now exiting loop");
                    break;
                }
            }
        }







    }
}
