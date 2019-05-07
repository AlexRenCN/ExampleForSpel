package com.alex.spel;

import com.alex.bean.User;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * bean引用
 */
public class BeanReferences {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new MyBeanResolver());
        User user = parser.parseExpression("@user").getValue(context,User.class);
        System.out.println(user.getName());
    }
    public static class MyBeanResolver implements BeanResolver {

        @Override
        public Object resolve(EvaluationContext context, String beanName) throws AccessException {
            User user=new User();
            user.setName("alex");
            context.setVariable("user",user);
            return user;
        }
    }
}