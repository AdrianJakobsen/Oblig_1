package Oppgave1;


import java.util.Arrays;

public class MinReturned {


    public static <E extends Comparable<E>> E min(E[] list) {

        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("Array was empty/does not exist");
        }
        Arrays.sort(list);
        return list[0];
    }
}