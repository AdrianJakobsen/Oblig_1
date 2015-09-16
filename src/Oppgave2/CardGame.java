package Oppgave2;


import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class CardGame {

    private ArrayDeque<String> numbers;
    private ArrayDeque<String> mathSymbols;
    private StringTokenizer tokens;

    public CardGame() {
        numbers = new ArrayDeque<>();
        mathSymbols = new ArrayDeque<>();
    }

    public int evaluateExpression(String expression) {
        tokens = new StringTokenizer(expression, "+-/*%", true);
        scanTokens();
        int sum = processTokens();
        return sum;
    }

    public void scanTokens() {
        while (tokens.hasMoreTokens()) {
            String nextToken = tokens.nextToken().trim();
            if (nextToken.length() == 0) {
                continue;
            } else if (nextToken.equals("+") || nextToken.equals("-") || nextToken.equals("*") || nextToken.equals("/")) {
                mathSymbols.addFirst(nextToken);
            } else {
                numbers.addFirst(nextToken);
            }
        }
    }

    private int processTokens() {
        int sum = Integer.parseInt(this.numbers.pop());
        String mathSymbol;

        for(int i=0; i<3; i++) {
            mathSymbol = mathSymbols.pop();
            if (mathSymbol.equals("+")) {
                sum = sum + Integer.parseInt(this.numbers.pop());
            } else if (mathSymbol.equals("-")) {
                sum = sum - Integer.parseInt(this.numbers.pop());
            } else if (mathSymbol.equals("*")) {
                sum = sum * Integer.parseInt(this.numbers.pop());
            } else if (mathSymbol.equals("/")) {
                sum = sum / Integer.parseInt(this.numbers.pop());
            }
        }
        return sum;
    }

}
