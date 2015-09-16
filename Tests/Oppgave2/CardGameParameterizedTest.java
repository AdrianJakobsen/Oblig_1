package Oppgave2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CardGameParameterizedTest {

    private CardGame calc;
    private String inputExpression;
    private int answer;


    public CardGameParameterizedTest(String inputExpression, int answer) {
        this.inputExpression = inputExpression;
        this.answer = answer;
    }

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"5+5*2-6", 9},
                {"(5*2)+5-10", 5},
                {"2+8+2-2", 10},
                {"9-5+3+2", 9},
                {"13-6-2+6", 11},
                {"12+12-10-2", 12},
                {"2*(3*2+(2-1)-5)", 1}
        });
    }

    @Before
    public void setup() {
        calc = new CardGame();
    }

    @Test
    public void evaluateExpression_ReturnCorrectAnswearToTheExpression() {
        int returnedAnswer = calc.evaluateExpression(inputExpression);
        assertEquals(answer, returnedAnswer);
    }

}