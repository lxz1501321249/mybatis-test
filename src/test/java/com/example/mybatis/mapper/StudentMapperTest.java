package com.example.mybatis.mapper;

import com.example.mybatis.domain.Sex;
import com.example.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class StudentMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @BeforeEach
        //每次执行某个单元测试之前执行这个方法
    void setUp() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @AfterEach
        //某个单元测试执行完毕后执行这个方法
    void tearDown() {
        if (sqlSession != null)
            sqlSession.close();
    }
    @Test
    void findAll() {
        studentMapper.findAll().forEach(System.out::println);
    }

    @Test
    void save() {
        Student tom = new Student("Tom", Sex.M);
        Student jerry = new Student("Jerry", Sex.M);
        studentMapper.save(tom);
        studentMapper.save(jerry);
        sqlSession.commit();
    }
}