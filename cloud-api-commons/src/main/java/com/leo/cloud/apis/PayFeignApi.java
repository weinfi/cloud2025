package com.leo.cloud.apis;

import com.leo.cloud.entities.PayDTO;
import com.leo.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    @GetMapping("/pay/get/{id}")
    Result<PayDTO> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/get/config")
    String getConsulInfo();
}
