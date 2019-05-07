package com.alex.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;



/**
 * 关系运算符
 */
public class RelationalOperators {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();
        //等于
        System.out.println(parser.parseExpression("1 == 2").getValue(boolean.class));
        //不等于
        System.out.println(parser.parseExpression("1 != 2").getValue(boolean.class));
        //大于
        System.out.println(parser.parseExpression("1 > 2").getValue(boolean.class));
        //小于
        System.out.println(parser.parseExpression("1 < 2").getValue(boolean.class));
        //大于等于
        System.out.println(parser.parseExpression("1 >= 2").getValue(boolean.class));
        //小于等于
        System.out.println(parser.parseExpression("1 <= 2").getValue(boolean.class));
        //是否是子类
        System.out.println(parser.parseExpression("1 instanceof T(String)").getValue(boolean.class));
        //正则
        System.out.println(parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));
        //并
        System.out.println(parser.parseExpression("1 == 2 and 2==2").getValue(boolean.class));
        //或
        System.out.println(parser.parseExpression("1 == 2 or 2==2").getValue(boolean.class));
        //不
        System.out.println(parser.parseExpression("!false").getValue(boolean.class));
        //并且不
        System.out.println(parser.parseExpression("2 == 2 and !false").getValue(boolean.class));
        //加
        System.out.println(parser.parseExpression("1 + 2").getValue(double.class));
        //减
        System.out.println(parser.parseExpression("1 - 2").getValue(double.class));
        //乘
        System.out.println(parser.parseExpression("1 * 2").getValue(double.class));
        //除
        System.out.println(parser.parseExpression("1 / 2").getValue(double.class));
        //取模
        System.out.println(parser.parseExpression("6 % 5").getValue(double.class));
        //幂运算
        System.out.println(parser.parseExpression("2 ^ 2").getValue(double.class));
    }

}