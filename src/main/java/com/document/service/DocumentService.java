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


    public List<Document> selectDocumentByDocument(String document);


}
