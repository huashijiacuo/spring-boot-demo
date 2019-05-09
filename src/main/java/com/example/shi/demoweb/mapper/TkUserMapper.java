package com.example.shi.demoweb.mapper;

import com.example.shi.demoweb.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @title: UserTkMapper </br>
 * @createDate: 2019/5/9 10:20 </br>
 * @author: shihsh  </br>
 * @description: tk.mybatis </br>
 * @version: V1.0
 **/

@Component(value = "userTkMapper")
@org.apache.ibatis.annotations.Mapper
public interface TkUserMapper  extends Mapper<User> {
}
