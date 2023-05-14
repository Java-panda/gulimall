package com.atguigu.gulimall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "gulimall-ware")
@Component
public interface WareClient {

}
