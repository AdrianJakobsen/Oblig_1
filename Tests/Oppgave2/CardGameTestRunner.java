package Oppgave2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by adrian on 15.09.15.
 */
public class CardGameTestRunner {

    public static void main(String[] args){

        Result result = JUnitCore.runClasses(CardGameParameterizedTest.class);
        for (Failure fail: result.getFailures()){
            System.out.println(fail.toString());
        }
        if(result.wasSuccessful()){
            System.out.println("all Test finished succsesful.");
        }

    }
}
