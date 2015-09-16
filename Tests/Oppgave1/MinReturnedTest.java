package Oppgave1;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MinReturnedTest {

    MinReturned comperer;
    Integer[] oneElementInIntArray;
    Integer[] twoElementInIntArray;
    Integer[] sevenElemetInIntArray;
    String[] OneElementInStringArray;
    String[] TwoElementInStringArray;
    String[] sevenElementInStringArray;
    Double[] oneElementInDoubleArray;
    Double[] twoElementInDoulbeArray;
    Double[] sevenElementInDoubleArray;
    String[] emptyStringArray;
    Integer[] arrayWithoutLenght;
    Double[] arrayWithNoInitializedElements;

    @Before
    public void setUp() {
        comperer = new MinReturned();
        oneElementInIntArray = new Integer[]{2};
        twoElementInIntArray = new Integer[]{7, 4};
        sevenElemetInIntArray = new Integer[]{19, 2, 9, 5, 1, 6, 14};
        OneElementInStringArray = new String[]{"bob"};
        TwoElementInStringArray = new String[]{"Alfred", "carl"};
        sevenElementInStringArray = new String[]{"michael", "jim", "magnus", "thomas", "adrian", "mads", "frode"};
        oneElementInDoubleArray = new Double[]{2.7};
        twoElementInDoulbeArray = new Double[]{14.6, 12.0};
        sevenElementInDoubleArray = new Double[]{5.6,8.6,9.0,6.4,9.4,4.6,10.4};
        emptyStringArray = null;
        arrayWithoutLenght = new Integer[0];
        arrayWithNoInitializedElements = new Double[5];
    }

    @Test
    public void min_ReturnSmallestIntegerInAnArrayWithOnlyOneInteger_Two() {
        int returnedValue = comperer.min(oneElementInIntArray);
        assertEquals(2, returnedValue);
    }

    @Test
    public void min_ReturnSmallestIntegerInAnArrayWithTwoIntegers_4() {
        int returnedValue = comperer.min(twoElementInIntArray);
        assertEquals(4, returnedValue);
    }

    @Test
    public void min_ReturnSmallestIntegerInAnArrayWithSevenIntegers() {
        int returnedValue = comperer.min(sevenElemetInIntArray);
        assertEquals(1, returnedValue);
    }

    @Test
    public void min_ReturnedSmallestStringInAnArrayWithOnlyOneString_bob() {
        String returnedValue = comperer.min(OneElementInStringArray);
        assertEquals("bob", returnedValue);
    }

    @Test
    public void min_ReturnedSmallestStringInAnArrayWithTwoElementsInString_Alfred() {
        String returnedValue = comperer.min(TwoElementInStringArray);
        assertEquals("Alfred", returnedValue);
    }

    @Test
    public void min_ReturnedSmallestStringInAnArrayWithSevenElementsInString_adrian() {
        String returnedValue = comperer.min(sevenElementInStringArray);
        assertEquals("adrian", returnedValue);
    }

    @Test
    public void min_ReturnedSmallestDoubleInAnDoubleArrayWithOnlyOneElement_TwoCommaSeven() {
        double returnedValue = comperer.min(oneElementInDoubleArray);
        assertEquals(2.7, returnedValue, 0);
    }

    @Test
    public void min_ReturnedSmallestDoubleInAnDoubleArrayWithTwoElements_TwelveCommaZero(){
        double returnedValue = comperer.min(twoElementInDoulbeArray);
        assertEquals(12.0, returnedValue, 0);
    }

    @Test
    public void min_ReturnedSmallesDoubleInAnDoubleArrayWithSevenElements_FourCommaSix(){
        double returnedValue = comperer.min(sevenElementInDoubleArray);
        assertEquals(4.6, returnedValue, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void min_WhenSendingInAnNullArrayReturnWithexception_IlligalArgumentException(){
        String expectedException = comperer.min(emptyStringArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void min_WhenSendingInAnArrayWithoutAnyLengthReturnWithException_IlligalArgumentException(){
        int expectedException = comperer.min(arrayWithoutLenght);
    }

    @Test(expected = NullPointerException.class)
    public void min_WhenSendingInAnArrayWithoutAnyInitializedElementsReturnWithException_IlligalArgumentException(){
        double expectedException = comperer.min(arrayWithNoInitializedElements);
    }
    @Test
    public void min_CircleOneSmallerThanCircleTwo_MinusOne(){
        Circle circle1 = new Circle(2.5);
        Circle circle2 = new Circle(5);
        Circle[] arrayOfCirles = new Circle[]{circle1,circle2};
        double returnedValue = comperer.min(arrayOfCirles).radius;
        assertEquals(2.5, returnedValue,0);
    }

}