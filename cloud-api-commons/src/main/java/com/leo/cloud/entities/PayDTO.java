package com.leo.cloud.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PayDTO implements Serializable {
    private Integer id;
    private String payNo;
    private String orderNo;
    private String userId;
    private BigDecimal amount;
}
