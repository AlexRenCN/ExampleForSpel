package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合投影
 */
public class CollectionProjection {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        Map<String,Integer> map=new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        context.setVariable("map",map);
        List<Integer> list=parser.parseExpression("#map.![value]").getValue(context,List.class);
        for (int anInt:
                list) {
            System.out.println(anInt);
        }
    }
}