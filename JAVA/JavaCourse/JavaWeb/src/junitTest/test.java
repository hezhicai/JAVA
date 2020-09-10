package junitTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test {
    @Before//加入before注解 每次执行test方法时都会先执行
    public void before(){
        System.out.println("-------开始白盒测试-------------");

    }
    @Test//单元测试
    public void test1(){
        String str="测试一";
        System.out.println("str");
        //断言 如果断言准确 那么就会出现绿色  断言错误就会出现红色
        Assert.assertEquals("测试",str);//“测试一位断言值” str位实际值
    }
    @After//加入after注解 每次执行test方法后都会后执行
    public void after(){
        System.out.println("------结束白盒测试---------------");
    }

}
