package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private  String gender;
    private  Date bir;

    public User(String name, String gender, Date bir) {
        this.name = name;
        this.gender = gender;
        this.bir = bir;
    }

    public User() {
    }
    public String getBir(){
        if(bir!=null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
            String format_date = sdf.format(bir);
            return format_date;
        }else {
            return "";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
