package Oppgave2;


import org.junit.Before;
import org.junit.Test;

import java.util.InputMismatchException;

import static org.junit.Assert.*;
public class PostfixNotationTest {

    PostfixNotation postfixNotation;

    @Before
    public void setUp(){
        postfixNotation = new PostfixNotation();
    }

    @Test
    public void calculate_sendInOneNumber_5(){
        assertEquals(5, postfixNotation.evaluateExpression("5"),0);
    }

    @Test
    public void calculate_sendInOneNumber_12(){
        assertEquals(12, postfixNotation.evaluateExpression("12"),0);
    }

    @Test
    public void calculate_addTwoNumbers_17(){
        assertEquals(17, postfixNotation.evaluateExpression("5 12 +"),0);
    }

    @Test
    public void calculate_CalculateExpression_9(){
        assertEquals(9, postfixNotation.evaluateExpression("1 2 + 3 *"), 0);
    }

    @Test(expected = InputMismatchException.class)
    public void sendInAnEmptyString(){
        postfixNotation.evaluateExpression("");
    }
    @Test(expected = InputMismatchException.class)
    public void sendInAnNullStringObject(){
        postfixNotation.evaluateExpression(null);
    }



}