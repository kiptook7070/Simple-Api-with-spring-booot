package com.kiptoo.SpringbyKiptoo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private String departmentAddress;

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    //Constructor with all the fields
    public Department(Long departmentId, String departmentCode, String departmentName, String departmentAddress) {
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
    }
    //Default Constructor

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                '}';
    }
}
