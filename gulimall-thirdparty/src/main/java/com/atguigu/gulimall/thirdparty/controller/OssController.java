package com.atguigu.gulimall.thirdparty.controller;

import com.atguigu.gulimall.common.utils.R;
import com.atguigu.gulimall.thirdparty.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("thirdparty/oss")
public class OssController {
    @Autowired
    private OssService ossService;
    /**
     * 图标上传认证取得
     * @return
     */
    @RequestMapping("/getPolicy")
    //@RequiresPermissions("product:brand:delete")
    public R getPolicy(){
        Map<String,String> map = ossService.getPolicy();
        return R.ok().setData(map);
    }
}
