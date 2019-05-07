package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 数组构造
 */
public class ArrayConstruction {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        int[] ints=parser.parseExpression("new int[3]").getValue(context,int[].class);
        System.out.println("length-"+ints.length);
        for (int anint:
                ints) {
            System.out.println(anint);
        }
        int[] ints2=parser.parseExpression("new int[]{1,2,3,4}").getValue(context,int[].class);
        System.out.println("length-"+ints2.length);
        for (int anint:
                ints2) {
            System.out.println(anint);
        }
        int[][] ints3=parser.parseExpression("new int[4][3]").getValue(context,int[][].class);
        System.out.println("length-"+ints3.length);
        for (int[] anArray:
                ints3) {
            System.out.println(anArray.length);
        }
    }
}