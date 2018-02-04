package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/12.
 */
@Entity
@Table(name = "cn_cm_rules")
@Data
public class Rules implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rules;
}
