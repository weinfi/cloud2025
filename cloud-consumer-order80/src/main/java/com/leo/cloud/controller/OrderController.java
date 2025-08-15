package com.leo.cloud.controller;

import com.leo.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.StringJoiner;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private DiscoveryClient discoveryClient;

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/pay/get/{id}")
    public Object getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/" + id, Result.class, id);
    }

    @GetMapping("/get/config")
    public String getConsulInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/config" , String.class);
    }

    @GetMapping("/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        System.out.println("=================");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            StringJoiner joiner = new StringJoiner("\t");
            joiner.add(instance.getServiceId());
            joiner.add(instance.getHost());
            joiner.add(instance.getPort() + "");
            joiner.add(instance.getUri() + "");
            System.out.println(joiner);
        }
        return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
    }
}