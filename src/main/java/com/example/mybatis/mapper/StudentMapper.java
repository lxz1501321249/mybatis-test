package com.example.mybatis.mapper;

import com.example.mybatis.domain.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAll();
    int save(Student student);
}