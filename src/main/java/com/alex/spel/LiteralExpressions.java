package com.alex.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 文字表达式
 * 可以处理字符串、日期、数值（int，real，十六进制）、布尔和空
 * 字符串使用单引号分割
 */
public class LiteralExpressions {
    public static void main(String[] args) {
        //===============支持的数据类型=============
        ExpressionParser parser=new SpelExpressionParser();
        // 字符串
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        System.out.println(helloWorld);
        //日期
        String currentTime = (String)parser.parseExpression("new java.util.Date().toLocaleString()").getValue();
        System.out.println(currentTime);
        //数值
        double avogadrosNumber = (Double) parser.parseExpression("6.0221415E+23").getValue();
        System.out.println(avogadrosNumber);
        //十六进制
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        System.out.println(maxValue);
        //布尔
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        System.out.println(trueValue);
        //空值
        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(nullValue);

    }
}