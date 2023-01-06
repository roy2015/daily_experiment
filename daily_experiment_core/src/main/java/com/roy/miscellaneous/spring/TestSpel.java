package com.roy.miscellaneous.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mapping.model.SpELContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;


/**
 *
 *
 * @author guojun
 * @date 2022/12/1 16:45
 *
 * https://blog.csdn.net/m0_66876551/article/details/123946622?ops_request_misc=&request_id=&biz_id=102&utm_term=spel&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-123946622.nonecase&spm=1018.2226.3001.4187
 */
@Slf4j
public class TestSpel {

    @Data
    public class Inventor {

        private String name;
        private String nationality;
        private String[] inventions;
        private Date birthdate;
        private PlaceOfBirth placeOfBirth;



        public Inventor(String name, String nationlity) {
            this.name = name;
            this.nationality = nationlity;
        }

        public Inventor(String name, String nationality, Date birthdate) {
            this.name = name;
            this.nationality = nationality;
            this.birthdate = birthdate;
        }

        // 省略其它方法
    }

    @Data
    public class PlaceOfBirth {

        private String city;
        private String country;
        // 省略其它方法
    }


    SpelExpressionParser parser;
    // 评估上下文
    SimpleEvaluationContext context;

    @Before
    public void before() {
        parser = new SpelExpressionParser();
        context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
    }

    @Test
    public void test_over_root() {
        // 创建  Inventor 对象
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian", c.getTime());
        // 1 定义解析器
        ExpressionParser parser = new SpelExpressionParser();
        // 指定表达式
        Expression exp = parser.parseExpression("name");
        // 在 tesla对象上解析
        String name = (String) exp.getValue(tesla);
        System.out.println(name); // Nikola Tesla

        exp = parser.parseExpression("name == 'Nikola Tesla'");
        // 在 tesla对象上解析并指定返回结果
        boolean result = exp.getValue(tesla, Boolean.class);
        System.out.println(result); // true
    }


    @Test
    public void test_literal() {
        ExpressionParser parser = new SpelExpressionParser();

        // 字符串 "Hello World"
        String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
        System.out.println(helloWorld);

        double num = (Double) parser.parseExpression("6.0221415E+23").getValue();
        System.out.println(num);

        // int  2147483647
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        System.out.println(maxValue);

        // 负数
        System.out.println((Integer) parser.parseExpression("-100").getValue());

        // boolean
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        System.out.println(trueValue);

        // null
        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(nullValue);
    }

    /**
     * 属性 数组 列表 map 索引
     */
    @Test
    public void test2(){
        Inventor inventor = new Inventor("发明家1", "中国");
        // 发明作品数组
        inventor.setInventions(new String[] {"发明1","发明2","发明3","发明4"});

        // 1 属性
        String name = parser.parseExpression("name").getValue(context, inventor, String.class);
        System.out.println("属性： " + name);
        // 属性： 发明家1

        // 2 数组表达式
        String invention = parser.parseExpression("inventions[3]").getValue(context, inventor, String.class);
        System.out.println("数组表达式: " + invention);
        // 数组表达式: 发明4

        // 3 List
        List strList = Arrays.asList("str1", "str2", "str3");
        String str = parser.parseExpression("[0]").getValue(context, strList, String.class);
        System.out.println(str);
        // str1

        // 4 map
        Map map = new HashMap<String, String>();
        map.put("xxx", "ooo");
        map.put("xoo", "oxx");
        String value = parser.parseExpression("['xoo']").getValue(context, map, String.class);
        System.out.println(value);
        // oxx
    }


    // 内联List
    @Test
    public void test3() {
        List numbers = (List) parser.parseExpression("{1,3,5,7}").getValue(context);
        System.out.println(numbers);
        //[1, 3, 5, 7]
        List listOfList = (List) parser.parseExpression("{{1,3,5,7},{0,2,4,6}}").getValue(context);
        System.out.println(listOfList);
        // [[1, 3, 5, 7], [0, 2, 4, 6]]
    }

    /**
     * 4 内联Map
     */
    @Test
    public void test4(){
        Map<String, Object> infoMap =
                (Map<String, Object>) parser.parseExpression("{'name':'name', password:'111'}").getValue();
        System.out.println(infoMap);
        //{name=name, password=111}

        Map mapOfMap =
                (Map) parser.parseExpression("{name:{first:'xxx', last:'ooo'}, password:'111'}").getValue(context);
        System.out.println(mapOfMap);
        // {name={first=xxx, last=ooo}, password=111}
    }

    /**
     *
     * 类类型T
     * 使用特殊的 T 运算符指定 java.lang.Class 的实例（类型）。
     *
     * 类中的静态变量、静态方法属于Class， 可以通过T(xxx).xxx调用。
     */
    @Test
    public void test11(){
        // 1 获取类的Class java.lang包下的类可以不指定全路径
        Class value = parser.parseExpression("T(String)").getValue(Class.class);
        System.out.println(value);

        // 2 获取类的Class 非java.lang包下的类必须指定全路径
        Class dateValue = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        System.out.println(dateValue);

        // 3 类中的静态变量 静态方法属于Class 通过T(xxx)调用
        boolean trueValue = parser.parseExpression(
                "T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR")
                .getValue(Boolean.class); // true
        System.out.println(trueValue);
        Long longValue = parser.parseExpression("T(Long).parseLong('9999')").getValue(Long.class);
        System.out.println(longValue);// 9999
    }

    /**
     * 表达式模板 #{}
     */
    @Test
    public void test19() {
        String randomStr = parser.parseExpression("随机数字是： #{T(java.lang.Math).random()}", new TemplateParserContext())
                .getValue(String.class);
        System.out.println(randomStr);
    }

    @Test
    public void test19_1() {
        String randomStr = parser.parseExpression("随机数字是： #{11}", new TemplateParserContext())
                .getValue(String.class);
        System.out.println(randomStr);
    }

    @Test
    public void test19_2() {
        String randomStr = parser.parseExpression("随机数字是： ${11}", new TemplateParserContext())
                .getValue(String.class);
        System.out.println(randomStr);
    }


    /**
     * 变量 #
     *
     * 可以使用#variableName 语法来引用表达式中的变量。通过在 EvaluationContext 实现上使用 setVariable 方法设置变量。
     */
    @Test
    public void test13() {
        Inventor inventor = new Inventor("xxx", "xxx");
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("newName", "new ooo");
        // 使用预先的变量赋值 Name 属性
        parser.parseExpression("Name = #newName").getValue(context, inventor);
        System.out.println(inventor.getName()); // new ooo
    }

    @Test
    public void test14() {
        SimpleEvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();
        context.setVariable("list1", new ArrayList<Integer>() {{add(1);add(2);}});
        // 使用预先的变量赋值 Name 属性
        List value = parser.parseExpression("#list1").getValue(context, List.class);
        log.debug("{}", value.size());
        Integer longValue =   parser.parseExpression("T(Integer).parseInt('12')").getValue( Integer.class);
//        parser.parseExpression("T(org.springframework.util.CollectionUtils).isEmpty(#list1)").getValue(context, Integer.class);

    }



}
