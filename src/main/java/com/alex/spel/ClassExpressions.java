package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 类表达式
 */
public class ClassExpressions {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext listContext = new StandardEvaluationContext();
        Class classes=parser.parseExpression("T(java.lang.String)").getValue(Class.class);
        System.out.println(classes.getName());
    }
}