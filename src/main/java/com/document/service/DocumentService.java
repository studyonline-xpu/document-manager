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

    /*public boolean deleteDocumentById(String id);

    public List<Document> queryByDocumentName(String documentName);

    public List<Document> queryByAllText(String allText);

    public List<Document> queryByLike(String like);*/

}
