package com.document.pojo;

import java.io.Serializable;
import java.util.List;

public class Class implements Serializable {
    private String classId;

    private String className;

    private Boolean isFather;

    private String fatherId;

    private Integer sort;

    private static final long serialVersionUID = 1L;
    //自己加的属性及相关方法
    private List<Class> childClass;

    public List<Class> getChildClass() {
        return childClass;
    }

    public void setChildClass(List<Class> childClass) {
        this.childClass = childClass;
    }
    //结束
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}