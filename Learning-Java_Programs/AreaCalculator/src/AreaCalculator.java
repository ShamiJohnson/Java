public class AreaCalculator {
    public static double area(double radius){

        if (radius<0){
            return -1.0;
        }

        double PI = Math.PI;

        double finalArea = radius*radius*PI;
        return finalArea;
    }



    public static double area(double x, double y){
        if ((x<0)||(y<0)){
            return -1.0;
        }


        double areaOfRectangle = x*y;
        return areaOfRectangle;

    }









}
