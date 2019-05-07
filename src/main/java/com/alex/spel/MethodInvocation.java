package com.alex.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 方法调用
 */
public class MethodInvocation {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        String string=parser.parseExpression("'abc'.replace('bc','aa')").getValue(String.class);
        System.out.println(string);
    }
}