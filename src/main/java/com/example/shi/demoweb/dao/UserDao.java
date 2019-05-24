package com.example.shi.demoweb.dao;

import com.example.shi.demoweb.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @title: User </br>
 * @createDate: 2019/5/4 0:18 </br>
 * @author: shihsh  </br>
 * @description: UserDao  </br>
 * @version: V1.0
 **/

@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO user(id,name, age, birthday) VALUES(#{id}, #{name}, #{age}, #{birthday})")
    void insertUser(@Param("id") Long id, @Param("name") String name, @Param("age") Byte age, @Param("birthday") Date birthday);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE  user SET id = #{id}, name = #{name}, age = #{age}, birthday= #{birthday} WHERE id = #{id}")
    void updateUser(@Param("id") Long userId, @Param("name") String name, @Param("age") Byte age, @Param("birthday") Date birthday,
                    @Param("id") Long id);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from user WHERE id = #{id}")
    void deleteUser(@Param("id") Long id);
}

