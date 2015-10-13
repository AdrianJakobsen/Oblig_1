package Oppgave2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PostfixNotationParameterizedTest {
    PostfixNotation postfixNotation;

    @Before
    public void setUp() {
        postfixNotation = new PostfixNotation();
    }

    public PostfixNotationParameterizedTest(String expression, int result) {
        this.expression = expression;
        this.result = result;
    }

    private final String expression;
    private final int result;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String("1 2 +"), 3},
                {new String("2 1 +"), 3},
                {new String("1 2 -"), -1},
                {new String("2 1 -"), 1},
                {new String("1 2 *"), 2},
                {new String("2 1 *"), 2},
                {new String("1 2 /"), 0},
                {new String("2 1 /"), 2},
        });
    }

    @Test
    public void parameterizedTest() {
        assertEquals(postfixNotation.evaluateExpression(expression), result,0);
    }
}