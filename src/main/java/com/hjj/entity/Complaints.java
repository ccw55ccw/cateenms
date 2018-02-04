package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "cn_cm_complaints")
@Data
public class Complaints implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String stuNo;
    private String stuName;
    private String stuPhone;
    private String stuEmail;
    private Date storageTime;
    private Long employeeId;
    private String employeeName;
    private String memo;

    private String state; //0未处理 1已处理
    private String result;//处理结果
}
