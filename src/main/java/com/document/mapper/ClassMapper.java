package com.document.mapper;

import com.document.pojo.Class;
import com.document.pojo.ClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int deleteByPrimaryKey(String classId);

    int insert(Class record);

    int insertSelective(Class record);

    List<Class> selectByExample(ClassExample example);

    Class selectByPrimaryKey(String classId);

    //自己加的方法
    /**
     * 查询父类类别的方法
     * @return
     */
    List<Class> selectAllFatherClass();

    //自己加的方法
    /**
     * 根据父类Id查询所有的子类的类别
     * @param fatherId 父类类别的id
     * @return
     */
    List<Class> selectAllClass(String fatherId);

    int updateByExampleSelective(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}