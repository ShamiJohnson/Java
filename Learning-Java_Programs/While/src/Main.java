public class Main {
    public static void main(String[] args) {

//        int count= 1;
////        while(count != 6){
////            System.out.println("Count value is "+count);
////            count++;
////        }


        System.out.println(isEvenNumber(90));

        int number= 4;
        int finishNumber=20;

        int totalNumber=0;

        while (number <= finishNumber){
            number++;

            if(!isEvenNumber(number)){
                continue;
            }

            System.out.println("Even Number "+ number);

            totalNumber++;
            if(totalNumber>5){
                break;
            }






        }

        System.out.println("total even number: "+totalNumber);



    }



    public static boolean isEvenNumber(int number){

        if ((number%2)==0){
            return true;
        }

        return false;
    }



}
