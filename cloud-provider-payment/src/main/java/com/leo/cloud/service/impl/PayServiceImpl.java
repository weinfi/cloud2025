package com.leo.cloud.service.impl;

import com.leo.cloud.entities.Pay;
import org.springframework.stereotype.Service;
import com.leo.cloud.service.PayService;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class PayServiceImpl implements PayService {
    @Override
    public Pay getById(Integer id) {
        Pay pay = new Pay();
        pay.setId(id);
        pay.setPayNo("sadg");
        pay.setAmount(BigDecimal.valueOf(66541L));
        pay.setUpdateTime(new Date());
        return pay;
    }
}
