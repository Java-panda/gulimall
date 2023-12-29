package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Jpanda
 * @email liujianipanda@gmail.com
 * @date 2023-05-05 00:44:18
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listbyTree(Map<String, Object> params);

    int removeCategoryWithOutMenuReferenceByIds(List<Long> asList);

    public List<Long> getCatelogPath(Long attrGroupId);
}

