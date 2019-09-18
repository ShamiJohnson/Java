public class NumberPalindrome {
    public static boolean isPalindrome(int number){

        int reverse=0;

        int lastDigit = number%10;
        reverse = reverse*10;




        while (number > 0) {
            lastDigit = number % 10;
            number = number / 10;
            reverse *= 10;
            reverse += lastDigit;

        }







        if (number==reverse){
            return true;
        }

        return false;
    }
}
