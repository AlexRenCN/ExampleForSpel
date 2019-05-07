package com.alex.spel;

import com.alex.bean.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


/**
 * 变量
 */
public class Variables {
    public static void main(String[] args) {
        //设置变量
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("aaa","aaa");
        User user=new User();
        context.setVariable("user",user);
        parser.parseExpression("#user.name = #aaa").getValue(context);
        System.out.println(user.getName());
        //this代表当前上下文
        EvaluationContext thisContext = new StandardEvaluationContext();
        int[] intArray=new int[]{1,2,3,4,5,6,7,8,9,10};
        thisContext.setVariable("intArray",intArray);
        //当前处理的对象是intArray，则可以用#this来表示#intArray
        int[] intResult=parser.parseExpression("#intArray.?[#this>5]").getValue(thisContext,int[].class);
        for (int anInt:
                intResult) {
            System.out.println(anInt);
        }
        //root代表根对象，即上下文构造时传入的对象
        EvaluationContext rootContext = new StandardEvaluationContext(intArray);
        int[] rooyResult=parser.parseExpression("#root.?[#this>5]").getValue(rootContext,int[].class);
        for (int anInt:
                rooyResult) {
            System.out.println(anInt);
        }
    }
}