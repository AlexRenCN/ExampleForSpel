package com.alex.spel;

import com.alex.bean.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 三元运算符
 */
public class TernaryOperator {

    public static void main(String[] args) {
        //三元运算符
        ExpressionParser parser=new SpelExpressionParser();
        String result=parser.parseExpression("1==1?'yes':'no'").getValue(String.class);
        System.out.println(result);
        //Elvis运算符
        User user=new User();
        EvaluationContext context = new StandardEvaluationContext(user);
        String result1=parser.parseExpression("name?:'no name'").getValue(context,String.class);
        System.out.println(result1);
        user.setName("alex");
        String result2=parser.parseExpression("name?:'no name'").getValue(context,String.class);
        System.out.println(result2);
    }
}