package com.leo.cloud.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Pay {
    private Integer id;
    private String payNo;
    private String orderNo;
    private String userId;
    private BigDecimal amount;
    private Date createTime;
    private Date updateTime;
}
