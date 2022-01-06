package com.zhu.onemanager.utlis;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName Strings.java
 * @Description TODO
 * @createTime 2022年01月07日 00:23:00
 */
public class Strings {

    /**
     * @Author ggball
     * @Description 解析占位符
     * @Date  2022/1/7
     * @Param [content 模板, values 值]
     * @return java.lang.String
     **/
    public static String solve(String content, String... values) {
        return PlaceholderResolver.solve(content,values);
    }

    /**
     * @Author ggball
     * @Description 头部添加字符
     * @Date  2022/1/7
     * @Param [content, value]
     * @return java.lang.String
     **/
    public static String insert(String content,String value) {
        return value + content;
    }

    /**
     * @Author ggball
     * @Description 尾部添加字符
     * @Date  2022/1/7
     * @Param [content, value]
     * @return java.lang.String
     **/
    public static String append(String content,String value) {
        return  content + value;
    }


}
