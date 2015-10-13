package Oppgave2;

import java.util.ArrayDeque;
import java.util.InputMismatchException;

public class PostfixNotation {
    ArrayDeque<Integer> stack = new ArrayDeque();

    public int evaluateExpression(String expression) {
        if (expression == null || expression.equals("")){
            throw new InputMismatchException("cannot be empty or null");
        }
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression, "+-/*% ", true);
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if(token.length()==0){
                continue;
            }else if(token.equals("+") ||token.equals("-")||token.equals("*")||token.equals("/")||token.equals("%")){
                calculation(token);
            }else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private void calculation(String operator) {
        switch (operator){
            case "+": stack.push(stack.pop() + stack.pop());
                break;
            case "-": stack.push(stack.pop() - stack.pop());
                break;
            case "*": stack.push(stack.pop() * stack.pop());
                break;
            case "/": stack.push(stack.pop() / stack.pop());
                break;
            case "%": stack.push(stack.pop() % stack.pop());
                break;
            default: throw new InputMismatchException();
        }


    }
}
