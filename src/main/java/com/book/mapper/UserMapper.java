package com.book.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.book.entity.User;


public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    User getUser(@Param("username")String username, @Param("password")String password);
}
