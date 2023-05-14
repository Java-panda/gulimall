package com.atguigu.gulimall.client;

import com.atguigu.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "gulimall-coupon")
@Component
public interface CouponClient {
    @RequestMapping("/coupon/coupon/list")
    public R list(@RequestParam Map<String, Object> params);
}
