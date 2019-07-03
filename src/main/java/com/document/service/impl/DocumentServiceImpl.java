package com.document.service.impl;

import com.document.mapper.DocumentMapper;
import com.document.pojo.Document;
import com.document.pojo.DocumentExample;
import com.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文档服务实现类
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    /**
     * 根据文档类别的Id查询文档所有信息
     * @param classId 文档类别的id
     * @return
     */
    @Override
    public List<Document> queryByClassId(String classId) {
        List<Document> documentList = documentMapper.queryByClassId(classId);
        return documentList;
    }

    /**
     * 根据文档名称模糊查询文档信息
     * @param documentName 文档实体
     * @return
     */
    @Override
    public List<Document> queryByLikeDocumentName(String documentName) {
        documentName = "%"+documentName+"%";
        List<Document> documentList = documentMapper.selectByLikeDocumentName(documentName);
        return documentList;
    }

    /**
     * 添加文档
     * @param document 文档实体
     * @return
     */
    @Override
    public boolean addDocument(Document document) {
        return false;
    }

    /**
     * 更新文档
     * @param document 文档实体
     * @return
     */
    @Override
    public boolean updateDocument(Document document) {
        return false;
    }

    /**
     * 根据文档内容查询文档集合
     * @param document 文档内容片段
     * @return
     */
    @Override
    public List<Document> selectDocumentByDocument(String document) {
        document = "%" + document + "%";
        List<Document> documents = documentMapper.selectDocumentByDocument(document);
        return documents;
    }
}
