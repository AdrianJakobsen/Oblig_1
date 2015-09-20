package Oppgave3;


import java.util.Arrays;
import java.util.Comparator;

public class GeometricObject implements Comparable<GeometricObjectCompare>{

    public static <E> E[] selectionSort(E[] list, Comparator<? super E> comparator){
        Arrays.sort(list);
        return list;
    }

    @Override
    public int compareTo(GeometricObjectCompare o) {
        return 0;
    }


    public double getArea() {
        return 0;
    }
}
