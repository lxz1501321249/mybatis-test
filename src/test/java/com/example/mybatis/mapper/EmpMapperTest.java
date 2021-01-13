package com.example.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class EmpMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private EmpMapper empMapper;

    @BeforeEach //每次执行某个单元测试之前执行这个方法
    void setUp() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        empMapper = sqlSession.getMapper(EmpMapper.class);
    }

    @AfterEach //某个单元测试执行完毕后执行这个方法
    void tearDown() {
        if (sqlSession != null)
            sqlSession.close();
    }


    @Test
    void findAll() {
        empMapper.findAll().forEach(System.out::println);
    }
}