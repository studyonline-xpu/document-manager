package com.document.controller;

import com.document.pojo.Document;
import com.document.pojo.SystemResult;
import com.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Map;

/**
 * @author RenJing
 */
@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    DocumentService documentService;

    /**
     * 根据文档类别查询文档所有信息
     * @param classId
     * @return
     */
    @RequestMapping(value = "/queryByClassId")
    @ResponseBody
    public SystemResult queryByClassId(String classId){
        List<Document> documents = documentService.queryByClassId(classId);
        SystemResult systemResult;
        if (documents != null) {
            systemResult = SystemResult.build(200, "根据文档类别查询文档成功");
            systemResult.setData(documents);
        } else {
            systemResult = SystemResult.build(400,"根据文档类别查询文档失败");
        }
        return systemResult;
    }

    /**
     * 根据文档名称查询所有文档信息
     * @param documentName 文档名称
     * @param map 存放数据
     * @return
     */
    @RequestMapping(value = "/queryByDocumentName")
    public String queryByDocumentName(String documentName, Map map) {
        List<Document> documents = documentService.queryByDocumentName(documentName);
        SystemResult systemResult;
        if (documents != null) {
            systemResult = SystemResult.build(200, "根据文档名称查询成功");
            systemResult.setData(documents);
            map.put("documents", documents);
            map.put("systemResult",systemResult);
        } else {
            systemResult = SystemResult.build(400, "根据文档名称查询失败");
        }
        return "redirect:/index/table-basic";
    }

    /**
     * 根据文档内容查询文档集合
     * @param document 文档内容片段
     * @param map
     * @return
     */
    @RequestMapping("/selectDocumentByDocument")
    public String selectDocumentByDocument(String document, Map map){
        List<Document> documents = documentService.selectDocumentByDocument(document);
        SystemResult systemResult;
        if(documents != null){
            systemResult = SystemResult.build(200, "根据文档内容查询成功");
            systemResult.setData(documents);
            map.put("documents", documents);
            map.put("systemResult", systemResult);
        }else {
            systemResult = SystemResult.build(400, "根据文档内容查询失败");
        }
        return "redirect:/index/table-basic";
    }
}
