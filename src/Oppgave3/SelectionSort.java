package Oppgave3;


import java.util.Comparator;

public class SelectionSort {

    public static <E> E[] selectionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMinIndex = i;
            for (int j = (i + 1); j < list.length; j++) {
                if (comparator.compare(list[i], list[j]) > 0) {
                    E temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                E temp = list[currentMinIndex];
                list[currentMinIndex] = list[i];
                list[i] = temp;
            }
        }
        return list;
    }

}
