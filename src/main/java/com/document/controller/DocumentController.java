package com.document.controller;

import com.document.pojo.Class;
import com.document.pojo.Document;
import com.document.pojo.SystemResult;
import com.document.pojo.User;
import com.document.service.ClassService;
import com.document.service.DocumentService;
import com.document.util.FastDFSClient;
import com.document.util.IdUtil;
import com.document.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
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
        System.out.println(documents);
        SystemResult systemResult;
        if (documents != null) {
            systemResult = SystemResult.build(200, "根据文档名称查询成功");
            systemResult.setData(documents);
            map.put("documents", documents);
        } else {
            systemResult = SystemResult.build(400, "根据文档名称查询失败");
        }
        return "backstage/documentList";
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

    /**
     * 上传文档附件
     * @param uploadFile
     * @return 返回url
     */
    @Value("101.132.78.78")
    String IMAGE_SERVER_URL;
    @RequestMapping("/upload")
    public String upLoadFile(MultipartFile uploadFile,Map map){
        try{
            //创建fastDFS的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("D:/编程相关/ItellWorksapce/document/src/main/resources/conf/client.conf");
            //取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.indexOf(".") + 1);
            //上传文件，并得到图片的地址和文件名
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //补充url
            url = IMAGE_SERVER_URL + "/" + url;
            //封装到对象里
            map.put("error", 0);
            map.put("url", "http://"+url);
        }catch (Exception e){
            e.printStackTrace();
            map.put("error", 1);
            map.put("url", "图片上传失败");
        }
        List<Class> classes = classService.queryAllClass();
        map.put("classResult",classes);
        return "index/form-basic";
    }

    /**
     * 添加文档记录
     * @param document 文档
     * @return 返回json 提示
     */
    @RequestMapping("/insertDocument")
    public String insertDocument(Document document,Map map){
        document.setDocumentId(IdUtil.next());
        document.setUpdateTime(new Date());
        List<Class> classes = classService.queryAllClass();
        if(documentService.addDocument(document)) {

        }else {
        }
        map.put("classResult", classes);
        return "index/form-basic";
    }

    /**
     * 更新文档
     *
     * @param document 文档
     * @return 放回json提示
     */
    @RequestMapping("/updateDocument")
    public String updateDocument(Document document, Map map) {
        document.setUpdateTime(new Date());
        if (documentService.updateDocument(document)) {
            Document documents = documentService.selectDocumentById(document.getDocumentId());
            map.put("document",documents);
        }
        List<Class> classes = classService.queryAllClass();
        map.put("classResult",classes);
        return "index/watch";
    }

    /**
     * 查询所有文档，根据时间排序
     * @return
     */
    @RequestMapping("/selectAllDocument")
    public String selectAllDocument(Map map){
        List<Document> documents = documentService.selectAllDocument();
        map.put("documents", documents);
        SystemResult systemResult;
        if(documents != null){
            systemResult = SystemResult.build(200, "根据文档内容查询成功");
            systemResult.setData(documents);
        }else {
            systemResult = SystemResult.build(400, "根据文档内容查询失败");
        }
        return "backstage/documentList";
    }

    /**
     * 根据文档id删除文档
     * @param documentId 文档id
     * @return
     */
//    @ResponseBody
    @RequestMapping("/deleteByDocumentId")
    public String deleteByDocumentId(String documentId, Map map){
        System.out.println(documentId);
        if(documentService.deleteByDocumentId(documentId)){
            map.put("msg", "文档删除成功");
        }else {
            map.put("msg", "文档删除失败");
        }
        List<Document> documents = documentService.selectAllDocument();
        map.put("documents", documents);
        return "backstage/documentList";
    }

    /**
     * 根据文档Id查看文档以及子类
     * @param documentId
     * @param result
     * @return
     */
    @RequestMapping("/selectDocumentById")
    public String selectDocumentById(String documentId, Map result) {
        Document document = documentService.selectDocumentById(documentId);
        List<Class> classList = classService.queryAllClass();
        if (document != null) {
            result.put("classResult", classList);
            result.put("document", document);
        }
        return "index/watch";
    }
}
