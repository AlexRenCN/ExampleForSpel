package com.alex.spel;

import com.alex.bean.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 赋值
 */
public class Assignment {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext listContext = new StandardEvaluationContext();
        User user=new User();
        parser.parseExpression("name").setValue(user,"alex");
        System.out.println(user.getName());
    }
}