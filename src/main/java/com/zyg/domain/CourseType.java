package com.zyg.domain;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/25 21:25
 */
public class CourseType {
    private Integer TypeId;
    private String TypeName;

    @Override
    public String toString() {
        return "CourseType{" +
                "TypeId=" + TypeId +
                ", TypeName='" + TypeName + '\'' +
                '}';
    }

    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer typeId) {
        TypeId = typeId;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}
