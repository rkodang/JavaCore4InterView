package com.gumdom;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class TestBase {
    protected SqlSessionFactory build;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-configs.xml");
         this.build = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    public static void main(String[] args) {
        String url="classpath:mybatis-configs.xml";
    }

    @Test
    public void TextSqlSessionFactory(){
        System.out.println(build);
        SqlSession sqlSession = build.openSession();
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);

    }

}
