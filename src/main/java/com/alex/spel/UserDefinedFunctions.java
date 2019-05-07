package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 用户定义的函数
 */
public class UserDefinedFunctions {
    public static void main(String[] args) throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.registerFunction("sayHello", UserDefinedFunctions.class.getDeclaredMethod("sayHello", new Class[
                ]{String.class}));
        parser.parseExpression("#sayHello('alex')").getValue(context);
    }

    public static void sayHello(String name) {
        System.out.println("hello " + name);
    }
}