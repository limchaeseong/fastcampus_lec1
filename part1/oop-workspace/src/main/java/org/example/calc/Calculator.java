package org.example;

import org.example.calculate.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(int operand1, String operator, int operand2) {

        /* 방법 1
        if ("+".equals(operator)) {
            return operand1 + operand2;
        } else if("-".equals(operator)) {
            return operand1 - operand2;
        } else if("*".equals(operator)) {
            return operand1 * operand2;
        } else if("/".equals(operator)) {
            return operand1 / operand2;
        }
        return 0;
         */

        /* 방법 2
        return ArithmeticOperator.calculate(operand1, operator, operand2);
         */

        /* 방법 3 */
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
