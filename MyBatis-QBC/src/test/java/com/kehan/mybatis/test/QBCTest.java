package com.kehan.mybatis.test;

import com.kehan.mybatis.bean.User;
import com.kehan.mybatis.bean.UserExample;
import com.kehan.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kehan
 * @creat 2022-06-23-22:13
 */
public class QBCTest {

    @Test
    public void TestQBC(){
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(is);
            sqlSession = build.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(1, "zhu", "123", "345", "567");
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameIsNotNull().andUsernameLike("%h%");

        int i = mapper.updateByExample(user, userExample);
        System.out.println(i);

    }
}
