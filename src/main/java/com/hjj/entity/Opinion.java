package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "cn_cm_opinion")
@Data
public class Opinion implements Serializable{
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
    private Date startTime;
    private Date endTime;
    private String memo;
}
