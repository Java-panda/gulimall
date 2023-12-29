package com.atguigu.gulimall.common.handler;

import com.atguigu.gulimall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice()
@Slf4j
public class GlobalExcetionHandler {
    public GlobalExcetionHandler() {
        if (log.isDebugEnabled()){
            log.debug("GlobalExcetionHandler全局校验器启动成功！！！！");
        }
    }

    @ExceptionHandler()
    public R validationException(MethodArgumentNotValidException e){
        //获取校验的error
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(ee->{
            //字段名称：错误消息
            errors.put(ee.getField(),ee.getRejectedValue()+":"+ee.getDefaultMessage());

        });
        return R.error(400,"参数校验出错！").put("data",errors);
    }
}
