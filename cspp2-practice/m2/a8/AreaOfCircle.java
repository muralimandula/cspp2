/*
*Trying Something.
*/
import java.util.Scanner;

/**
*main clas for area of circle.
*/
public final class AreaOfCircle {
    /**
    *cratin private.
    */
    private AreaOfCircle() {
    //abstraction
    }
    /**
    *writing aarea of circle.
    @param args string on construction
    */
    public static void main(final String[] args) {
        Scanner radiusInput = new Scanner(System.in);
        System.out.print("Enter the radius of the circle : ");
        final double radius = radiusInput.nextDouble();
        System.out.print(area(radius));
    }


    /**
    *Area calculation.
    @param x of circle
    @return area of circle
    */
    public static double area(final double x) {
        return pi() * x * x;

    }

    /**
    @return pi value
    *value of pi.
    */
    public static double pi() {
        final double pii = 3.14;
        return pii;

    }
}
