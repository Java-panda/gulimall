package com.atguigu.gulimall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "gulimall-product")
@Component
public interface ProductClient {

}
