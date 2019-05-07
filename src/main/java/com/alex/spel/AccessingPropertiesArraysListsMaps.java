package com.alex.spel;

import com.alex.bean.Grade;
import com.alex.bean.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访问属性，数组，列表，映射
 * 使用.表示嵌套属性值
 */
public class AccessingPropertiesArraysListsMaps {
    public static void main(String[] args) {
        ExpressionParser parser=new SpelExpressionParser();

        User user=new User();
        user.setName("张三");
        user.setAge(18);
        Grade grade=new Grade();
        grade.setNo(22);
        grade.setName("2018级");
        user.setGrade(grade);
        //访问属性
        String username=(String)parser.parseExpression("name").getValue(user);
        System.out.println(username);
        //访问嵌套属性
        String gradename=(String)parser.parseExpression("grade.name").getValue(user);
        System.out.println(gradename);
        //访问数组
        String[] strings=new String[]{"a","b","c"};
        EvaluationContext arrayContext = new StandardEvaluationContext();
        arrayContext.setVariable("strings",strings);
        String arrayValue=parser.parseExpression("#strings[1]").getValue(arrayContext,String.class);
        System.out.println(arrayValue);
        //访问列表
        List<String> lists=new ArrayList<>(3);
        lists.add("a");
        lists.add("b");
        lists.add("c");
        EvaluationContext listContext = new StandardEvaluationContext();
        listContext.setVariable("lists",strings);
        String listValue=parser.parseExpression("#lists[2]").getValue(listContext,String.class);
        System.out.println(listValue);
        //访问映射
        Map maps=new HashMap();
        maps.put("a","a");
        maps.put("b","b");
        maps.put("c","c");
        EvaluationContext mapsContext = new StandardEvaluationContext();
        mapsContext.setVariable("maps",maps);
        String mapsValue=parser.parseExpression("#maps['a']").getValue(mapsContext,String.class);
        System.out.println(mapsValue);
    }
}