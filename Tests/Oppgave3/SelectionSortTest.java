package Oppgave3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SelectionSortTest {


    @Test
    public void sort_SortListAndCheckOfTheyContainTheSameElements_true() {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
                new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        assertTrue(list.equals(SelectionSort.selectionSort(list, new GeometricComparator())));
    }

    @Test
    public void selectionSort_CompareToDiffrentArrays_false() {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
                new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        GeometricObject[] list2 = {new Circle(4), new Rectangle(4, 1), new Circle(5.2),
                new Rectangle(2.0, 5), new Circle(4.5), new Rectangle(4, 6), new Circle(6.1), new Rectangle(4.4, 6),
                new Circle(6.1), new Rectangle(4, 5)};
        assertFalse(SelectionSort.selectionSort(list, new GeometricComparator()).equals(list2));
    }


}