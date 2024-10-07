package org.example.calculator.tobe;


import org.example.calculator.domain.PositiveNumber;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDTION("+") {
        @Override
        public int arithemticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTUIN("-") {
        @Override
        public int arithemticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithemticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithemticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator){
        this.operator = operator;
    }

    public abstract int arithemticCalculate(final int operand1, final int operand2);

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        ArithmeticOperator arithmeticOperator= Arrays.stream(values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithemticCalculate(operand1.toInt(), operand2.toInt());

    }

}