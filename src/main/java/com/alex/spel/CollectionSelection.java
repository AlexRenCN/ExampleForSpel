package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合选择
 */
public class CollectionSelection {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Map<String,Integer> map=new HashMap();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        context.setVariable("list",list);
        context.setVariable("map",map);
        //list选择
        List<Integer> listResult=parser.parseExpression("#list.?[#this<2]").getValue(context,List.class);
        for (int anInt:
                listResult) {
            System.out.println(anInt);
        }
        //map value选择
        Map<String,Integer> mapResult=parser.parseExpression("#map.?[value<2]").getValue(context,Map.class);
        for (String key:
        mapResult.keySet()) {
            System.out.println("key: "+key+" value: "+mapResult.get(key));
        }
        //map key选择
        Map<String,Integer> mapResult2=parser.parseExpression("#map.?[key=='c']").getValue(context,Map.class);
        for (String key:
                mapResult2.keySet()) {
            System.out.println("key: "+key+" value: "+mapResult2.get(key));
        }
    }
}