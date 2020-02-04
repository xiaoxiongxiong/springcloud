package com.microservice.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)//链式风格访问
@Data
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String content;
    private Integer views;
    private String blogType;
    private Date updateTime;
    private Date createTime;
    private String dbSource;
}
