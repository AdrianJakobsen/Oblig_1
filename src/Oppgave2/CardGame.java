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

//    public int _eval(String exp) {
//        int sum = 0;
//        int pari = exp.indexOf('(');
//
//        if (pari != -1) {
//            // int n = exp.lastIndexOf(')');
//            // String _exp = exp.substring(pari +1, n);
//            // exp = exp.substring(0, pari - 1) + exp.substring(pari +1, n);
//            // sum += _eval(_exp) + process(exp);
//        } else {
//            // sum =  process(exp)
//        }
//
//        return sum;
//    }


    public int evaluateExpression(String expression) {
        int sum = 0;
        if(expression.indexOf('(')!=-1){
            int lastIndexOfBobble = expression.lastIndexOf(')');
            int firstIndexOfBobble = expression.indexOf('(');
            String expressionInBobble = expression.substring(firstIndexOfBobble+1, lastIndexOfBobble);
            String expressionWithoutBobble = expression.substring(0, firstIndexOfBobble-1) + expression.substring(lastIndexOfBobble,expression.length());
            sum = evaluateExpression(expressionInBobble) + scanAndProcessTokens(expressionWithoutBobble);
        }else{
            sum = scanAndProcessTokens(expression);
        }

        return sum;
    }

    public int scanAndProcessTokens(String expression) {
        tokens = new StringTokenizer(expression, "+-/*%", true);
        int sum = 0;
        while (tokens.hasMoreTokens()) {
            String nextToken = tokens.nextToken().trim();
            if (nextToken.length() == 0) {
                continue;
            } else if (nextToken.equals("*") || nextToken.equals("/")) {
                sum = doMath(nextToken, Integer.parseInt(numbers.pop()), Integer.parseInt(tokens.nextToken()));
            }else if (nextToken.equals("+") || nextToken.equals("-")){
                operators.addLast(nextToken);
            }else {
                numbers.addLast(nextToken);
            }
        }

        while (numbers.size()!=0){
           String mathSymbol= operators.pop();
            int nextNumber = Integer.parseInt(numbers.pop());
            if (mathSymbol.equals("+")) {
                sum = doMath("+", sum, nextNumber);
            } else if (mathSymbol.equals("-")) {
                sum = doMath("-", sum, nextNumber);
            }
        }
        return sum;
    }

//    private int processTokens() {
//        int sum = Integer.parseInt(this.numbers.pop());
//        String mathSymbol;
//
//        for(int i=0; i<3; i++) {
//            mathSymbol = m,athSymbols.pop();
//            if (mathSymbol.equals("+")) {
//                sum = sum + Integer.parseInt(this.numbers.pop());
//            } else if (mathSymbol.equals("-")) {
//                sum = sum - Integer.parseInt(this.numbers.pop());
//            } else if (mathSymbol.equals("*")) {
//                sum = sum * Integer.parseInt(this.numbers.pop());
//            } else if (mathSymbol.equals("/")) {
//                sum = sum / Integer.parseInt(this.numbers.pop());
//            }
//        }
//        return sum;
//    }

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
