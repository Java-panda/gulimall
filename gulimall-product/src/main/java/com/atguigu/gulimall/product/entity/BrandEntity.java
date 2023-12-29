package com.atguigu.gulimall.product.entity;

import com.atguigu.gulimall.common.valid.annotation.EnableValueList;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * 品牌
 * 
 * @author Jpanda
 * @email liujianipanda@gmail.com
 * @date 2023-05-05 00:44:18
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名称不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@EnableValueList(values = {0,1},message = "{com.atguigu.gulimall.common.valid.annotation.EnableValueList}")
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	private String firstLetter;
	/**
	 * 排序
	 */
	@Positive(message = "排序只能是数字")
	private Integer sort;

}
