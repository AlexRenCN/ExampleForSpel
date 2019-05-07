package com.alex.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 表达模板
 * 允许文本和模块混合，模块和模块混合
 */
public class TemplatedExpressions {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //使用模板上下文
        ParserContext context = new TemplateParserContext();
        //context作为parse时候的参数而不是get时候的参数
        String result =
                parser.parseExpression("random number is #{T(java.lang.Math).random()}",context)
                        .getValue( String.class);
        System.out.println(result);
    }
}