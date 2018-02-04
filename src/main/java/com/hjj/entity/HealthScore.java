package com.hjj.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/12.
 */
@Entity
@Table(name = "cn_cm_health_score")
@Data
public class HealthScore implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String score;
    private Date scoreTime;
}
