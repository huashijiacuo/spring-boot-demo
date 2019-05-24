package com.example.shi.demoweb.mapper;

import com.example.shi.demoweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @title: UserMapper.xml </br>
 * @createDate: 2019/5/5 17:03 </br>
 * @author: shihsh  </br>
 * @description: User mapper类 </br>
 * @version: V1.0
 **/

@Component
@Mapper
public interface UserMapper {

    User findUserByName(String name);

    void updateUser(User user);
}
