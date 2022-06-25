package com.kehan.mybatis;

import com.kehan.mybatis.mapper.UserMapper;
import com.kehan.mybatis.pojo.User;
import com.kehan.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author kehan
 * @creat 2022-06-21-21:38
 */
public class test {

    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.insertUser(null, "阿斯蒂芬", "123456", "23544", "120");
        System.out.println(result);
    }


    @Test
    public void ParameterTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.queryUserLikeUsername("1"));

    }
}
