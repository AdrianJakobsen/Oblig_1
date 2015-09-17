package Oppgave2;

import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by adrian on 17.09.15.
 */
public class StringCalculator {
    private ArrayDeque<Integer> numbers;
    private ArrayDeque<String> operators;
    private List<String> list;
    private StringTokenizer tokens;

    public StringCalculator (){

    }

    public int evaluateExpression(String expression) {
        tokens = new StringTokenizer(expression, "+-/*%", true);
        numbers = new ArrayDeque<>();
        operators= new ArrayDeque<>();

        while(tokens.hasMoreTokens()){
            list.add(tokens.nextToken());
        }
        for(String token : list){
            if(token.length()==0){
                continue;
            }
            else if(token.charAt(0)== '+' ||token.charAt(0)== '-' ||token.charAt(0)=='*'||token.charAt(0)=='/' ){
                while(!operators.isEmpty() && operators.equals("+") || operators.equals("-")
                        || operators.equals("*") || operators.equals("/")){
                    doMath(numbers,operators);
                }
            }
            else if(token.charAt(0)=='*'||token.charAt(0)=='/'){
                while(!operators.isEmpty() && operators.equals("*") || operators.equals("/")){
                    doMath(numbers,operators);
                }
            }
        }
    }
}
