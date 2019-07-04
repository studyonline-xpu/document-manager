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
        System.out.println(documentName);
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
        return documentMapper.insert(document) > 0;
    }

    /**
     * 更新文档
     * @param document 文档实体
     * @return
     */
    @Override
    public boolean updateDocument(Document document) {
        return documentMapper.updateByPrimaryKeyWithBLOBs(document) > 0;
    }

    /**
     * 根据文档内容查询文档集合
     * @param document 文档内容片段
     * @return
     */
    @Override
    public List<Document> selectDocumentByDocument(String document) {
        document = "'%" + document + "%'";
        List<Document> documents = documentMapper.selectDocumentByDocument(document);
        return documents;
    }

    /**
     * 根据userId查看个人履历
     * @param userId
     * @return
     */
    @Override
    public List<Document> queryByUserId(String userId) {
        return documentMapper.queryByUserId(userId);
    }

    /**
     * 部门经理查看部门简历
     * @param departmentId 部门id
     * @return
     */
    @Override
    public List<Document> queryByDepartmentId(String departmentId) {
        return documentMapper.queryByDepartmentId(departmentId);
    }

    /**
     * 查询所有文档
     * @return
     */
    @Override
    public List<Document> selectAllDocument() {
        return documentMapper.selectAllDocument();
    }

    /**
     * 根据文档id删除文档
     * @param documentId 文档id
     * @return
     */
    @Override
    public boolean deleteByDocumentId(String documentId) {
        return documentMapper.deleteByPrimaryKey(documentId) > 0;
    }
}
