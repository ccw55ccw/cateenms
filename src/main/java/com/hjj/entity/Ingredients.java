package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/12.
 */
@Entity
@Table(name = "cn_cm_ingredients")
@Data
public class Ingredients implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String source;
    private String stock;
    private String price;
    private String ingredientsUnitId;
    private Date storageTime;
}
