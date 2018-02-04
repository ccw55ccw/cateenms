package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "cn_cm_stock")
@Data
public class Stock implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String stock;
    private String unitId;
    private String unitName;
    private Date storageTime;
    private String memo;
}
