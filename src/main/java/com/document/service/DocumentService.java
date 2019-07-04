package com.document.service;

import com.document.pojo.Document;

import java.util.List;

/**
 * 文档服务
 */
public interface DocumentService {

    /**
     * 根据文档类别的Id查询文档所有信息
     * @param classId 文档类别的id
     * @return
     */
    public List<Document> queryByClassId(String classId);

    /**
     * 根据文档名称查询文档所有信息
     * @param documentName 文档的名称
     * @return
     */
    public List<Document> queryByLikeDocumentName(String documentName);

    /**
     * 添加文档
     * @param document 文档实体
     * @return
     */
    public boolean addDocument(Document document);

    /**
     * 更新文档
     * @param document 文档实体
     * @return
     */
    public boolean updateDocument(Document document);

    /**
     * 根据文档内容查询文档集合
     * @param document 文档内容片段
     * @return
     */
    public List<Document> selectDocumentByDocument(String document);

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

    /**
     * 查询所有文档
     * @return
     */
    List<Document> selectAllDocument();

    /**
     * 根据文档id删除文档
     * @param documentId 文档id
     * @return
     */
    boolean deleteByDocumentId(String documentId);
}
