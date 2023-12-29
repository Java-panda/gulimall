package com.atguigu.gulimall.common.valid.annotation;

import com.atguigu.gulimall.common.valid.validator.EnableIntegerListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        //自定义校验器
        validatedBy = {EnableIntegerListValidator.class}
)
/**
 * 自定义校验器注解
 * 1.必须包含message，groups，payload三个属性
 * 2.可以自定义其他属性，如[]values
 */
public @interface EnableValueList {
    //指定默认验证错误消息的key值，需要写一个ValidationMessages.properties配置文件保存相应的K，V值
    String message() default "{com.atguigu.gulimall.common.valid.annotation.EnableValueList}";
    //允许分组校验功能
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] values() default {};
}
