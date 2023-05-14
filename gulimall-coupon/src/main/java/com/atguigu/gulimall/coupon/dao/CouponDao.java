package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author Jpanda
 * @email liujianipanda@gmail.com
 * @date 2023-05-05 01:48:40
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
