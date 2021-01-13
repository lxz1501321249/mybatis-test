package com.example.mybatis.test;

import com.example.mybatis.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //mybatis-config.xml文件名和第3步中文件名一致
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        deptMapper.findAll().forEach(System.out::println);
        //deptMapper.save(new Dept(50, "xx", "yy"));
        //deptMapper.deleteByDeptNo(50);

        sqlSession.commit();
        sqlSession.close();
    }
}
