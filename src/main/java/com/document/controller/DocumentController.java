package com.document.controller;

import com.document.pojo.Class;
import com.document.pojo.Document;
import com.document.pojo.SystemResult;
import com.document.pojo.User;
import com.document.service.ClassService;
import com.document.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    @Autowired
    ClassService classService;

    /**
     * 根据文档类别查询文档所有信息
     * @param classId
     * @return
     */
    @RequestMapping(value = "/queryByClassId")
    public String queryByClassId(String classId, Map map, HttpSession httpSession){
        Object user = httpSession.getAttribute("user");
        List<Document> documents = null;
        if(classId.equals("32") && !user.getClass().getName().equals("Manager") && !((User)user).getRoleId().equals("1")){
            if(!((User) user).getRoleId().equals("2")){
                System.out.println("不是部门经理");
                documents = documentService.queryByUserId(((User) user).getUserId());//不是部门经理
            }else {
                System.out.println("是部门经理");
                documents = documentService.queryByDepartmentId(((User)user).getDepartmentId());
            }
        } else{
            System.out.println("最高权限");
            documents = documentService.queryByClassId(classId);
        }
        List<Class> classes = classService.queryAllClass();
        SystemResult systemResult;
        if (documents != null) {
            systemResult = SystemResult.build(200, "根据文档类别查询文档成功");
            systemResult.setData(documents);
        } else {
            systemResult = SystemResult.build(400,"根据文档类别查询文档失败");
        }
        map.put("result", documents);
        map.put("classes",classes);
        return "index/table-basic";
    }

    /**
     * 根据文档名称查询所有文档信息
     * @param documentName 文档名称
     * @param map 存放数据
     * @return
     */
    @RequestMapping(value = "/queryByDocumentName")
    public String queryByLikeDocumentName(String documentName, Map map) {
        List<Document> documents = documentService.queryByLikeDocumentName(documentName);
        SystemResult systemResult;
        if (documents != null) {
            systemResult = SystemResult.build(200, "根据文档名称查询成功");
            systemResult.setData(documents);
            map.put("documents", documents);
            map.put("systemResult",systemResult);
        } else {
            systemResult = SystemResult.build(400, "根据文档名称查询失败");
        }
        return "index/table-basic";
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
        return "/index/table-basic";
    }
}
