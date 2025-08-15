package com.leo.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced// 定义一个使用负载均衡的RestTemplate Bean
    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
