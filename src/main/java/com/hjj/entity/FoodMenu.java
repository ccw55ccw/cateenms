package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/12.
 */
@Entity
@Table(name = "cn_cm_foodmenu")
@Data
public class FoodMenu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String isWebShow;
    private Date tDate;
}
