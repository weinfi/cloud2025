package com.leo.cloud.controller;

import com.leo.cloud.entities.PayDTO;
import com.leo.cloud.resp.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leo.cloud.service.PayService;

@Tag(name = "支付微服务模块", description = "订单CRUD")
@Slf4j
@RestController
@RequestMapping("/pay")
/**
 * @RefreshScope 注解表示这个Controller会动态刷新配置
 * 当配置中心的配置发生变化时，会重新加载@Value注解的配置值
 * 需要配合@Value注解一起使用来实现配置的动态刷新
 */
@RefreshScope
public class PayController {
    @Autowired
    private PayService payService;

    @GetMapping("/get/{id}")
    @Operation(summary = "查询单个", description = "查询支付流水, 参数是Id")
    public Result<PayDTO> getById(@PathVariable("id") Integer id) {
        PayDTO payDTO = new PayDTO();
        BeanUtils.copyProperties(payService.getById(id), payDTO);
        return Result.success(payDTO);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/config")
    public String getConsulInfo(@Value("${global.config}") String globalConfig) {
        return "globalConfig: " + globalConfig + "\n" + "server port: " + port;
    }
}
