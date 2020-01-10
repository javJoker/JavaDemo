package com.self.demo.model;

import java.util.Objects;

public class Department {
    private int id;
    private String deptName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department() {
    }

    public Department(int id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return id == that.id &&
                deptName.equals( that.deptName );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, deptName );
    }
}
