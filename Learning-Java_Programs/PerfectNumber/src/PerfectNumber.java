public class PerfectNumber {
    public static boolean isPerfectNumber(int number){

        if(number<1){
            return false;
        }

        int dividingForPerfect = 1;
        int sumNumber = 0;

        while (dividingForPerfect<number){


            if ((number%dividingForPerfect)==0){
                System.out.println(dividingForPerfect);
                sumNumber = dividingForPerfect;
            }
            dividingForPerfect++;

        }
        sumNumber= sumNumber+sumNumber;
        //System.out.println("sum number: " + sumNumber);

        System.out.println("now number: "+ number);
        System.out.println("now Sum Number: "+ sumNumber);
        if (number==sumNumber){
            return true;
        }


        return false;
    }
}
