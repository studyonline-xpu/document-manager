package com.document.pojo;

import java.io.Serializable;
import java.util.List;

public class Class implements Serializable {
    private String classId;

    private String className;

    private Boolean isFather;

    private String fatherId;

    //自己加的属性
    /**
     * 子类的类别
     */
    private List<Class> childClass;

    private static final long serialVersionUID = 1L;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Boolean getIsFather() {
        return isFather;
    }

    public void setIsFather(Boolean isFather) {
        this.isFather = isFather;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId == null ? null : fatherId.trim();
    }

    public List<Class> getChildClass() {
        return childClass;
    }

    public void setChildClass(List<Class> childClass) {
        this.childClass = childClass;
    }
}