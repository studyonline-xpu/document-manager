package com.document.service;

import com.document.pojo.Document;

/**
 * 文档服务
 */
public interface DocumentService {

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

    /*public boolean deleteDocumentById(Integer id);

    public boolean queryByClassId(Integer classId);

    public List<Document> queryByDocumentName(String documentName);

    public List<Document> queryByAllText(String allText);

    public List<Document> queryByLike(String like);*/

}
