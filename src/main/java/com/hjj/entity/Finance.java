package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "cn_cm_finance")
@Data
public class Finance implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String num;
    private Integer numFlag;
    private String opTime;
    private String memo;
}
