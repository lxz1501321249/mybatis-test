package com.example.mybatis.mapper;

import com.example.mybatis.domain.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

class DeptMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private DeptMapper deptMapper;

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
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }

    @AfterEach //某个单元测试执行完毕后执行这个方法
    void tearDown() {
        if (sqlSession != null)
            sqlSession.close();
    }

    @Test
    void findAll() {
        deptMapper.findAll().forEach(System.out::println);
    }

    @Test
    void save() {
        deptMapper.save(new Dept(50, "xx", "yy"));
        sqlSession.commit();

    }

    @Test
    void deleteByDeptNo() {
        deptMapper.deleteByDeptNo(50);
        sqlSession.commit();
    }
}