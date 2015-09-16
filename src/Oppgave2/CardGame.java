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

    public int _eval(String exp) {
        int sum = 0;
        int pari = exp.indexOf('(');

        if (pari != -1) {
            // int n = exp.lastIndexOf(')');
            // String _exp = exp.substring(pari +1, n);
            // exp = exp.substring(0, pari - 1) + exp.substring(pari +1, n);
            // sum += _eval(_exp) + process(exp);
        } else {
            // sum =  process(exp)
        }

        return sum;
    }

    public int doMath(char operator, int operand1, int operand2) {

    }

    public int evaluateExpression(String expression) {
        int sum = 0;
        if(expression.indexOf('(')!=-1){
            int lastIndexOfBobble = expression.lastIndexOf(')');
            int firstIndexOfBobble = expression.indexOf('(');
            String expressionInBobble = expression.substring(firstIndexOfBobble+1, lastIndexOfBobble);
            String expressionWithoutBobble = expression.substring(0, firstIndexOfBobble-1) + expression.substring(lastIndexOfBobble,expression.length());
            sum += evaluateExpression(expressionInBobble) + scanAndProcessTokens(expressionWithoutBobble);
        }
        sum = processTokens();
        return sum;
    }

    public int scanAndProcessTokens(String expression) {
        tokens = new StringTokenizer(expression, "+-/*%", true);
        while (tokens.hasMoreTokens()) {
            String nextToken = tokens.nextToken().trim();
            if (nextToken.length() == 0) {
                continue;
            } else if (nextToken.equals("*") || nextToken.equals("/")) {
                mathSymbols.addLast(nextToken);
            }else if (nextToken.equals("+") || nextToken.equals("-")){

            }else {
                numbers.addLast(nextToken);
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
