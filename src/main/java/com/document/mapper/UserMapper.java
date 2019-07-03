package com.document.mapper;

import com.document.pojo.User;
import com.document.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //自己加的方法

    /**
     * 根据id和密码登录
     *
     * @param userId   用户id
     * @param password 用户密码
     * @return
     */
    User selectLogin(@Param("userId") String userId, @Param("password") String password);

    /**
     * 后台：查询所有用户
     * @return
     */
    List<User> selectAllUser();
}