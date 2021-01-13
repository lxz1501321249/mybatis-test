package com.example.mybatis.mapper;

import com.example.mybatis.domain.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> findAll();
    int save(Dept dept);
    int deleteByDeptNo(Integer deptNo);
}
