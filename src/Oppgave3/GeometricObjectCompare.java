package Oppgave3;

import java.util.Arrays;
import java.util.Comparator;

public class GeometricObjectCompare{


    private double area;


    public int compareTo(GeometricObject object1, GeometricObject object2) {
        double area1 = object1.getArea();
        double area2= object2.getArea();
        if(area1 > area2){
            return 1;
        }else if (area1 < area2){
            return -1;
        }else {
            return 0;
        }
    }

    public double getArea() {
        return area;
    }
}
