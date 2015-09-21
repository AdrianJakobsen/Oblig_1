package Oppgave2;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class CardGameTest {

    private CardGame calc;

    @Before
    public void setup(){
        calc = new CardGame();
    }

    @Test
    public void scanAndProcessTokens_fourteen(){
        int returnedAnswer = calc.evaluateExpression("2+3+4+5");
        assertEquals(14, returnedAnswer);
    }

    @Test(expected = NoSuchElementException.class)
    public void sendInAnEmptyString_NoSuchElementException(){
        calc.evaluateExpression("");
    }

    @Test(expected = InvalidParameterException.class)
    public void sendInAnInvalidExpression_InvalidParameterException(){
        calc.evaluateExpression("+2-4+5+6");
    }



}