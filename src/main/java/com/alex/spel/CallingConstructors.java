package com.alex.spel;

import com.alex.bean.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 调用构造函数
 */
public class CallingConstructors {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        User user=parser.parseExpression("new com.alex.bean.User()").getValue(User.class);
        user.setName("alex");
        System.out.println(user);
    }
}