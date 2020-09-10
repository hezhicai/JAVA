/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.table;/*
 *@Author:
 *@CreateTime:2020-05-13-44
 *@description:
 */

public class student {

    private int sno;
    private  String name;

    private String sex;

    public int getSno() {
        return sno;

    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
