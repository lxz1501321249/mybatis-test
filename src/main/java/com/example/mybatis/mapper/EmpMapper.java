package com.example.mybatis.mapper;

import com.example.mybatis.domain.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> findAll();
}
