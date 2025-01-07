package org.example.domain;

public class UserDao {
    private String version;
    public void selectList() {
        System.out.println("查询 User List version "+version);
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
