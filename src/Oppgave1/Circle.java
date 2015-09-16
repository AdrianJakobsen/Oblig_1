package Oppgave1;


public class Circle implements Comparable<Circle> {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle circle) {
        if (this.radius == circle.radius) {
            return 0;
        } else if (this.radius > circle.radius) {
            return 1;
        } else {
            return -1;
        }
    }
}