package com.example.mybatis.domain;

import java.util.Set;

public class Dept {
    private Integer deptNo;
    private String dName;
    private String loc;
    private Set<Emp> employees;

    public Dept() {
    }

    public Dept(Integer deptNo, String dName, String loc, Set<Emp> employees) {
        this.deptNo = deptNo;
        this.dName = dName;
        this.loc = loc;
        this.employees = employees;
    }

    public Dept(Integer deptNo, String dName, String loc) {
        this.deptNo = deptNo;
        this.dName = dName;
        this.loc = loc;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Set<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Emp> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", dName='" + dName + '\'' +
                ", loc='" + loc + '\'' +
                ", employees=" + employees +
                '}';
    }
}
