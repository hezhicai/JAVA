package domain;

import java.io.Serializable;

/**
 * 实现序列化 接口 可以讲user对象序列化 或保存user对象
 */

public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpwd() {
        return pwd;
    }

    public void setpwd(String pwd) {
        this.pwd = pwd;
    }

   /* @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }*/
}
