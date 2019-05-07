package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

/**
 * 内联列表
 */
public class InlineLists {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext listContext = new StandardEvaluationContext();
        List<Integer> numbers = parser.parseExpression("{1,2,3,4}").getValue(listContext,List.class);
        for (Integer anInt:
                numbers) {
            System.out.println("numbers:"+anInt);
        }
        List<List> listOfLists = parser.parseExpression("{{'a','b'},{'x','y'}}").getValue(listContext,List.class);
        for (List anInt:
                listOfLists) {
            System.out.println("listOfLists:"+anInt);
        }
    }

}