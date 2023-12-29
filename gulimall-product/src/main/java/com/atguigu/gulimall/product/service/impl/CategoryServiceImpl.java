package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.common.constant.ReturnCode;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gulimall.common.utils.PageUtils;
import com.atguigu.gulimall.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listbyTree(Map<String, Object> params) {
        return listbyTree(0L);
    }

    @Override
    public int removeCategoryWithOutMenuReferenceByIds(List<Long> asList) {
        try{
            //TODO 菜单如果被引用无法删除
            baseMapper.deleteBatchIds(asList);
            return ReturnCode.NORMAL;
        }catch (Exception e){
            return ReturnCode.ERROR;
        }
    }

    public List<CategoryEntity> listbyTree(Long parentId) {
        //条件构造
        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_cid",parentId);
        wrapper.orderByAsc("sort");
        //查出父ID列表
        List<CategoryEntity> categoryEntityList = baseMapper.selectList(wrapper);
        if (categoryEntityList==null||categoryEntityList.size()==0){
            //如果父ID列表为空,递归达到叶子节点
            return null;
        }else {
            //否则,递归查询设置子节点
            for (CategoryEntity categoryEntity : categoryEntityList) {
                categoryEntity.setChildren(listbyTree(categoryEntity.getCatId()));
            }
        }
        //返回最终的顶层列表
        return categoryEntityList;
    }

    /**
     * 获取某个三级分类的父分类路径
     * @param catId
     * @return
     */
    @Override
    public List<Long> getCatelogPath(Long catId) {
        List<Long> catelogPath = new ArrayList<>();
        getCatelogPath(catelogPath,catId);
        //反转
        Collections.reverse(catelogPath);
        return catelogPath;
    }

    /**
     * 递归获取
     * @param catelogPath
     * @param catId
     */
    private void getCatelogPath(List<Long> catelogPath,Long catId) {
        CategoryEntity categoryEntity = this.getById(catId);
        if (categoryEntity==null) {
            return;
        }else {
            catelogPath.add(categoryEntity.getCatId());
            getCatelogPath(catelogPath,categoryEntity.getParentCid());
        }
    }
}