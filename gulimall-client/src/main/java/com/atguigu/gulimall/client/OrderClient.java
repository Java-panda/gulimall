package com.atguigu.gulimall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "gulimall-order")
@Component
public interface OrderClient {

}
