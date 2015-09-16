package Oppgave2;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class CardGame {

    private ArrayDeque<String> numbers;
    private ArrayDeque<String> operators;
    private StringTokenizer tokens;
    public CardGame() {
        numbers = new ArrayDeque<>();
        operators = new ArrayDeque<>();
    }

    public int evaluateExpression(String expression) {
        int sum = 0;
        String bobbleSum;
        if(expression.indexOf('(')!=-1){
            int lastIndexOfBobble = expression.lastIndexOf(')');
            int firstIndexOfBobble = expression.indexOf('(');
            String expressionWithoutBobble;
            String expressionInBobble = expression.substring(firstIndexOfBobble+1, lastIndexOfBobble);
            bobbleSum = evaluateExpression(expressionInBobble) + "";
            expressionWithoutBobble = expression.substring(0, firstIndexOfBobble) + bobbleSum + expression.substring(lastIndexOfBobble+1, expression.length());
            sum = scanAndProcessTokens(expressionWithoutBobble);
        }else{
            sum = scanAndProcessTokens(expression);
        }
        return sum;
    }

    public int scanAndProcessTokens(String expression) {
        tokens = new StringTokenizer(expression, "+-/*%", true);
        int sum = 0;
        if(expression.contains("*")){// herrre gud
            int indexOfMultiplication = expression.indexOf('*');
            String expressionWithoutMulti;
            String multiplication = expression.substring(indexOfMultiplication-1, indexOfMultiplication+1);
        }
        while (tokens.hasMoreTokens()) {
            String nextToken = tokens.nextToken().trim();
            if (nextToken.length() == 0) {
                continue;
            } else if (nextToken.equals("*") || nextToken.equals("/")) {
                sum = doMath(nextToken, Integer.parseInt(numbers.pop()), Integer.parseInt(tokens.nextToken()));
            }
            else if (nextToken.equals("+") || nextToken.equals("-")){
                operators.addLast(nextToken);
            }
            else {
                numbers.addLast(nextToken);
            }
        }

        while (numbers.size()!=0){
//                int nextNumber = Integer.parseInt(numbers.pop());
                String mathSymbol = operators.pop();
                if (mathSymbol.equals("+")) {
                    sum = doMath("+", Integer.parseInt(numbers.pop()), Integer.parseInt(numbers.pop()));
                } else if (mathSymbol.equals("-")) {
                    sum = doMath("-", Integer.parseInt(numbers.pop()), Integer.parseInt(numbers.pop()));
                }
        }
        return sum;
    }

    public int doMath(String operator, int operand1, int operand2) {
        if (operator.equals("+")) {
            return operand1 +operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        }
        return 0;
    }
}