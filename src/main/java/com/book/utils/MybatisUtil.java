package com.book.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

    private static SqlSessionFactory init() throws IOException {
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
            return factory;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SqlSession getSession(boolean autocommit) throws IOException {
        return init().openSession(autocommit);
    }
}
