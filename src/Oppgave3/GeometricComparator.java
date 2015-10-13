package Oppgave3;

import java.io.Serializable;
import java.util.Comparator;

public class GeometricComparator implements Comparator<GeometricObject>, Serializable {


    public int compare(GeometricObject object1, GeometricObject object2) {
        double area1 = object1.getArea();
        double area2 = object2.getArea();
        if (area1 > area2) {
            return 1;
        } else if (area1 < area2) {
            return -1;
        } else {
            return 0;
        }
    }

}
