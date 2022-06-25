package com.kehan.mybatis.mapper;

import com.kehan.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kehan
 * @creat 2022-06-21-21:36
 */
public interface UserMapper {

    /*增加用户*/
    int insertUser(Integer id, String username, String password, String email, String phone);

    /*查询全部用户*/
    List<User> queryAllUser();

    /*通过用户名和密码查询用户*/
    User queryUserByUsernameAndPassword(String username, String password);

    /*通过用户名模糊查询用户*/
    User queryUserLikeUsername(@Param("username") String username);

}
