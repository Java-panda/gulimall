package com.atguigu.gulimall.common.valid.validator;

import com.atguigu.gulimall.common.valid.annotation.EnableValueList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.*;

/**
 * 自定义校验器：只允许用户输入注解中定义的值
 * 1.实现ConstraintValidator，并提供自定义校验注解，和类型
 * 2.实现initialize方法获取注解中的值
 * 3.实现isValid方法，判断当前校验的值是否满足条件
 */
public class EnableIntegerListValidator implements ConstraintValidator<EnableValueList,Integer> {
    private List<Integer> values = new ArrayList<>();
    @Override
    public void initialize(EnableValueList constraintAnnotation) {
        //将注解中定义的值保存到values中
        Arrays.stream(constraintAnnotation.values()).forEach(v->values.add(v));
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        //获取消息模板
        String messageKey = constraintValidatorContext.getDefaultConstraintMessageTemplate();
        String messageTemplate = getMessageTemplate(messageKey);
        System.out.println(messageTemplate);
        //拦截消息模板做业务修改
        messageTemplate=messageTemplate.replace("{value}",String.valueOf(integer));
        System.out.println(messageTemplate);
        //关闭默认消息渲染
        constraintValidatorContext.disableDefaultConstraintViolation();
        //重新使用新的消息模板
        constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation();
        //判断用户输入的值是否在values中
        return values.contains(integer);
    }

    public String getMessageTemplate(String key){
        ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages");
        if (bundle.containsKey(key)){
            return bundle.getString(key);
        }else {
            return "";
        }
    }
}
