package com.self.demo.model;


import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {


    private int userId;
    private Department dept;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public User() {
    }

    public User(int userId, Department dept) {
        this.userId = userId;
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                dept.equals( user.dept );
    }

    @Override
    public int hashCode() {
        return Objects.hash( userId, dept );
    }
}
