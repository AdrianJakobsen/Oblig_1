package Oppgave3;


import org.junit.Test;

import static org.junit.Assert.*;


public class GeometricObjectCompareTest {

    private GeometricObject[] listOfGeometricobjects = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
            new Circle(6.5), new Rectangle(4, 5)};


    @Test
    public void sort_SortListAndGetSmallestArea(){
        GeometricObject.selectionSort(listOfGeometricobjects);
    }

}