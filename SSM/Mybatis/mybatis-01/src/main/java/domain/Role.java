package domain;

/**
 * 角色表
 */
public class Role {
    private int id;
    private String ROLE_NAME;
    private String ROLE_DESC;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getROLE_DESC() {
        return ROLE_DESC;
    }

    public void setROLE_DESC(String ROLE_DESC) {
        this.ROLE_DESC = ROLE_DESC;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", ROLE_NAME='" + ROLE_NAME + '\'' +
                ", ROLE_DESC='" + ROLE_DESC + '\'' +
                '}';
    }
}
