package Oppgave2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardGameTest {

    private CardGame calc;

    @Before
    public void setup(){
        calc = new CardGame();
    }

    @Test
    public void scanAndProcessTokens(){
        int returnedAnswer = calc.evaluateExpression("2+3+4+5");
        assertEquals(14, returnedAnswer);
    }

}