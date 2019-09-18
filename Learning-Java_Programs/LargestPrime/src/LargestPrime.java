public class LargestPrime {
    public static int getLargestPrime(int number){



        int count = 0;
        int isAPrime=0;

        while (count<number){

            count++;

            if((count%count ==0)&&(count%1==0)){
                isAPrime=count;
            }

            System.out.println(isAPrime);
        }


        return -1;
    }
}
