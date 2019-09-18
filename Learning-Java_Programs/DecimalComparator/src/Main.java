public class Main {
    public static void main(String[] args) {
        boolean print = DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756, -3.175);
        System.out.println(print);
        print = DecimalComparator.areEqualByThreeDecimalPlaces(3.175, 3.176);
        System.out.println(print);
    }
}
