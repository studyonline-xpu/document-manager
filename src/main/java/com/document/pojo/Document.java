package com.document.pojo;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable {
    private String documentId;

    private String documentName;

    private String userId;

    private String classId;

    private Date updateTime;

    private String doucument;

    private String documentUrl;

    private static final long serialVersionUID = 1L;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName == null ? null : documentName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDoucument() {
        return doucument;
    }

    public void setDoucument(String doucument) {
        this.doucument = doucument == null ? null : doucument.trim();
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl == null ? null : documentUrl.trim();
    }
}