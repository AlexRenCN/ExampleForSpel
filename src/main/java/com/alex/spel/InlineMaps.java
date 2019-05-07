package com.alex.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;

/**
 * 内联映射
 */
public class InlineMaps {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        Map map = parser.parseExpression("{1:'a',2:'b',3:'c',4:'d'}").getValue(context,Map.class);
        for (Object key:
                map.keySet()) {
            System.out.println("Key: "+key+" value: "+map.get(key));
        }

        Map<Integer,Map> mapOfMaps = parser.parseExpression("{1:{a:'a1',b:'b1'},2:{c:'c1',d:'d1'}}").getValue(context,Map.class);
        for (Integer key:
                mapOfMaps.keySet()) {
            System.out.println("key:"+key);
            Map<String,Object> mapOfMap=mapOfMaps.get(key);
            for (String keyOfKey:
                    mapOfMap.keySet()) {
                System.out.println("Key: "+keyOfKey+" value: "+mapOfMap.get(keyOfKey));
            }
        }
    }

}