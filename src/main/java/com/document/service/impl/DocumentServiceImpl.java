package com.document.service.impl;

import com.document.mapper.DocumentMapper;
import com.document.pojo.Document;
import com.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文档服务实现类
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

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
}
