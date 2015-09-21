package Oppgave2;
import java.security.InvalidParameterException;
import java.util.*;

public class CardGame {

    private ArrayDeque<Integer> numbers;
    private ArrayDeque<Character> operators;

    public CardGame() {
        numbers = new ArrayDeque<>();
        operators = new ArrayDeque<>();
    }

    public int evaluateExpression(String expression) {
        if(expression.equals("")){
            throw new NoSuchElementException();
        }
        if(expression.charAt(0) == '+' || expression.charAt(0) == '-' ||expression.charAt(0) == '*' ||expression.charAt(0) == '/'){
            throw new InvalidParameterException();
        }
        int sum = 0;
        if (expression.indexOf('(') != -1) {
            int lastIndexOfBobble = expression.lastIndexOf(')');
            int firstIndexOfBobble = expression.indexOf('(');
            String expressionInBobble = expression.substring(firstIndexOfBobble + 1, lastIndexOfBobble);
            String bobbleSum = evaluateExpression(expressionInBobble) + "";
            String expressionWithoutBobble = expression.substring(0, firstIndexOfBobble) + bobbleSum + expression.substring(lastIndexOfBobble + 1, expression.length());
            sum = scanAndProcessTokens(expressionWithoutBobble);
        } else {
            sum = scanAndProcessTokens(expression);
        }
        return sum;
    }

    public int scanAndProcessTokens(String expression) {
        StringTokenizer tokens = new StringTokenizer(expression, "+-/*%", true);
        int sum;
        while (tokens.hasMoreTokens()) {
            String nextToken = tokens.nextToken().trim();
            if (nextToken.length() == 0) {
                continue;
            } else if (nextToken.equals("*") || nextToken.equals("/")) {
                numbers.addLast( doMath(nextToken.charAt(0), numbers.pop(), Integer.parseInt(tokens.nextToken().trim())));
            } else if (nextToken.equals("+") || nextToken.equals("-")) {
                operators.addLast(nextToken.charAt(0));
            } else {
                numbers.addLast(Integer.parseInt(nextToken));
            }
        }
        sum = numbers.pop();
        while (numbers.size() != 0) {
            sum = doMath(operators.pop(), sum, numbers.pop());
        }
        return sum;
    }

    public int doMath(char operator, int leftOperand, int rightOperand) {


        if (operator=='+') {
            return leftOperand + rightOperand;
        } else if (operator=='-') {
            return leftOperand - rightOperand;
        } else if (operator=='*') {
            return leftOperand * rightOperand;
        } else if (operator=='/') {
            return leftOperand / rightOperand;
        }
        throw new InputMismatchException();
    }
}