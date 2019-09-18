public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println("the sum of 125 is " +sumDigit(125));
        System.out.println("the sum of -125 is " +sumDigit(-125));
        System.out.println("the sum of 4 is " +sumDigit(4));
        System.out.println("the sum of 32123 is " +sumDigit(32123));

    }

    private static int sumDigit(int number) {
        if (number<10){
            return -1;
        }
        int sum =0;
        while (number>0){
            int digit = number%10;
            sum +=digit;

            number/=10;
        }

        return sum;
    }
}
