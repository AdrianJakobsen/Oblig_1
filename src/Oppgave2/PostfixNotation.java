package Oppgave2;

import java.util.ArrayDeque;
import java.util.InputMismatchException;

public class PostfixNotation {
    public double evaluateExpression(String postfixNotationExpression) {
        if(postfixNotationExpression == null || postfixNotationExpression.equals("")){
            throw new InputMismatchException("need a input");
        }
        String[] parts = postfixNotationExpression.split(" ");

        double numericValue = calculation(parts);
        return numericValue;
    }

    private double calculation(String[] parts) {
        ArrayDeque<Double> stack = new ArrayDeque();
        double value = 0;
        String regex = "[+|-|*|/]";
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].matches(regex)){
                double firstNumber = stack.pop();
                double secondNumber = stack.pop();
                switch (parts[i]){
                    case "+": value = firstNumber + secondNumber;
                        stack.add(value);
                        break;
                    case "-": value = firstNumber - secondNumber;
                        stack.add(value);
                        break;
                    case "*": value = firstNumber * secondNumber;
                        stack.add(value);
                        break;
                    case "/": value = firstNumber / secondNumber;
                        stack.add(value);
                        break;
                }
            }else {
                stack.add(Double.parseDouble(parts[i]));
            }
        }

        return stack.pop();
    }
}
