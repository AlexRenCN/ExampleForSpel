package com.alex.spel;

import com.alex.bean.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 安全导航运算
 */
public class SafeNavigationOperator {
    public static void main(String[] args) {
        //使用空返回代替空指针异常
        ExpressionParser parser=new SpelExpressionParser();
        User user=new User();
        EvaluationContext context = new StandardEvaluationContext(user);
        String result=parser.parseExpression("grade?.name").getValue(context,String.class);
        System.out.println(result);
    }
}