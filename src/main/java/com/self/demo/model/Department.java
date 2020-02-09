package com.self.demo.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author javJoker
 */
public class Department implements Cloneable, Serializable {
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof Department)) {
            return false;
        }
        Department that = (Department) o;
        return id == that.id &&
                deptName.equals( that.deptName );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, deptName );
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Department demo = null;
        try {
            //浅复制
            demo = (Department) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //深度复制
        demo.deptName = deptName;
        demo.id = id;
        return demo;

    }
}
