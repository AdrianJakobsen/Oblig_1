package Oppgave1;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MinReturnedTest {

    MinReturned comperer;


    @Before
    public void setUp() {
        comperer = new MinReturned();
    }

    @Test
    public void min_ReturnSmallestIntegerInAnArrayWithOnlyOneInteger_Two() {
        Integer[] oneElementInIntArray = new Integer[]{2};
        int returnedValue = comperer.min(oneElementInIntArray);
        assertEquals(2, returnedValue);
    }

    @Test
    public void min_ReturnSmallestIntegerInAnArrayWithTwoIntegers_4() {
        Integer[] twoElementInIntArray = new Integer[]{7, 4};

        int returnedValue = comperer.min(twoElementInIntArray);
        assertEquals(4, returnedValue);
    }

    @Test
    public void min_ReturnSmallestIntegerInAnArrayWithSevenIntegers() {
        Integer[] sevenElemetInIntArray = new Integer[]{19, 2, 9, 5, 1, 6, 14};
        int returnedValue = comperer.min(sevenElemetInIntArray);
        assertEquals(1, returnedValue);
    }

    @Test
    public void min_ReturnedSmallestStringInAnArrayWithOnlyOneString_bob() {
        String[] OneElementInStringArray = new String[]{"bob"};
        String returnedValue = comperer.min(OneElementInStringArray);
        assertEquals("bob", returnedValue);
    }

    @Test
    public void min_ReturnedSmallestStringInAnArrayWithTwoElementsInString_Alfred() {
        String[] TwoElementInStringArray = new String[]{"Alfred", "carl"};
        String returnedValue = comperer.min(TwoElementInStringArray);
        assertEquals("Alfred", returnedValue);
    }

    @Test
    public void min_ReturnedSmallestStringInAnArrayWithSevenElementsInString_adrian() {
        String[] sevenElementInStringArray = new String[]{"michael", "jim", "magnus", "thomas", "adrian", "mads", "frode"};
        String returnedValue = comperer.min(sevenElementInStringArray);
        assertEquals("adrian", returnedValue);
    }

    @Test
    public void min_ReturnedSmallestDoubleInAnDoubleArrayWithOnlyOneElement_TwoCommaSeven() {
        Double[] oneElementInDoubleArray = new Double[]{2.7};
        double returnedValue = comperer.min(oneElementInDoubleArray);
        assertEquals(2.7, returnedValue, 0);
    }

    @Test
    public void min_ReturnedSmallestDoubleInAnDoubleArrayWithTwoElements_TwelveCommaZero() {
        Double[] twoElementInDoulbeArray = new Double[]{14.6, 12.0};
        double returnedValue = comperer.min(twoElementInDoulbeArray);
        assertEquals(12.0, returnedValue, 0);
    }

    @Test
    public void min_ReturnedSmallesDoubleInAnDoubleArrayWithSevenElements_FourCommaSix() {
        Double[] sevenElementInDoubleArray = new Double[]{5.6, 8.6, 9.0, 6.4, 9.4, 4.6, 10.4};
        double returnedValue = comperer.min(sevenElementInDoubleArray);
        assertEquals(4.6, returnedValue, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void min_WhenSendingInAnNullArrayReturnWithexception_IlligalArgumentException() {
        String[] emptyStringArray = null;
        String expectedException = comperer.min(emptyStringArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void min_WhenSendingInAnArrayWithoutAnyLengthReturnWithException_IlligalArgumentException() {
        Integer[] arrayWithoutLenght = new Integer[0];
        int expectedException = comperer.min(arrayWithoutLenght);
    }

    @Test(expected = NullPointerException.class)
    public void min_WhenSendingInAnArrayWithoutAnyInitializedElementsReturnWithException_IlligalArgumentException() {
        Double[] arrayWithNoInitializedElements = new Double[5];
        double expectedException = comperer.min(arrayWithNoInitializedElements);
    }

    @Test
    public void min_CircleOneSmallerThanCircleTwo_MinusOne() {
        Circle circle1 = new Circle(2.5);
        Circle circle2 = new Circle(5);
        Circle[] arrayOfCirles = new Circle[]{circle1, circle2};
        double returnedValue = comperer.min(arrayOfCirles).radius;
        assertEquals(2.5, returnedValue, 0);
    }

}