package domain;

import java.util.List;

public class UserAccount {
    private int id;
    private String name;
    private String pwd;
    private List<AccountUser> accounts;

    public List<AccountUser> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountUser> accounts) {
        this.accounts = accounts;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



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



    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
