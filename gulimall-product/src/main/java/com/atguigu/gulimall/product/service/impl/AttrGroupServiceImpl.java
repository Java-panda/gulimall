package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;

import com.atguigu.gulimall.product.dao.AttrGroupDao;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import com.atguigu.gulimall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Long catelogId) {
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<>();
        if (catelogId!=null&&catelogId>0){
            queryWrapper.eq("catelog_id",catelogId);
        }
        Object key = params.get("key");
        if (key !=null){
            queryWrapper.and(wapper->wapper
                    .eq("attr_group_id",key)
                    .or()
                    .like("attr_group_name",key)
                    .or()
                    .like("descript",key));
        }
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}