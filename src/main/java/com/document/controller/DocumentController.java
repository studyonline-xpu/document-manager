package com.document.controller;

import com.document.pojo.Document;
import com.document.pojo.SystemResult;
import com.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

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
}
