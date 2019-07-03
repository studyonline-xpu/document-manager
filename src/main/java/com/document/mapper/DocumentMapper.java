package com.document.mapper;

import com.document.pojo.Document;
import com.document.pojo.DocumentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocumentMapper {
    long countByExample(DocumentExample example);

    int deleteByExample(DocumentExample example);

    int deleteByPrimaryKey(String documentId);

    int insert(Document record);

    int insertSelective(Document record);

    List<Document> selectByExampleWithBLOBs(DocumentExample example);

    List<Document> selectByExample(DocumentExample example);

    Document selectByPrimaryKey(String documentId);

    int updateByExampleSelective(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByExample(@Param("record") Document record, @Param("example") DocumentExample example);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKeyWithBLOBs(Document record);

    int updateByPrimaryKey(Document record);
    //自己添加的方法

    /**
     * 根据classId进行查询
     * @param classId 类别id
     * @return
     */
    List<Document> queryByClassId(String classId);
    /**
     * 根据名称检索文档
     * @param documentName
     * @return
     */
    List<Document> selectByLikeDocumentName(String documentName);
    /**
     * 根据内容检索文档
     * @param document 内容片段
     * @return
     */
    List<Document> selectDocumentByDocument(String document);

    /**
     * 根据userId查看个人履历
     * @param userId
     * @return
     */
    List<Document> queryByUserId(String userId);

    /**
     * 部门经理查看部门简历
     * @param departmentId 部门id
     * @return
     */
    List<Document> queryByDepartmentId(String departmentId);
}