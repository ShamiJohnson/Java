public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes){
        if (minutes<0){
            System.out.println("Invalid Value");
        }else if (minutes>=0) {
            long years = minutes / 525600;
            long remainingMinutes = minutes % 525600;
            long days = remainingMinutes / 1440;
            System.out.println(minutes + " min = " + years + " y "+ "and " + days + " d");
        }else {
            System.out.println("Invalid Value");
        }

    }

}

















//
//
//
//
//
//
//
//
//public class MinutesToYearsDaysCalculator {
//    public static void printYearsAndDays(long minutes){
//        if (minutes<0){
//            System.out.println("Invalid Value");
//        }else if (minutes>0){
//            long years= minutes/525600;
//            long remainingMinutes = minutes%525600;
//            long days= remainingMinutes/1440;
//            System.out.println(minutes+" min = "+ years + " y " + days + " d");
//        }else {
//            System.out.println("something went horribly wrong");
//        }
//    }
//
//}




//* printYearsAndDays(525600);  → should print "525600 min = 1 y and 0 d"
//
//        * printYearsAndDays(1051200); → should print "1051200 min = 2 y and 0 d"
//
//        * printYearsAndDays(561600);  → should print "561600 min = 1 y and 25 d"
//
