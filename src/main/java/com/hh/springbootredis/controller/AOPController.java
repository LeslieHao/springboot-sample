package com.hh.springbootredis.controller;

import com.hh.springbootredis.aop.Log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午10:32
 */
@Controller
public class AOPController {

    @RequestMapping("aop")
    @ResponseBody
    @Log(operateType = "test",operateName = "测试AOP")
    public String  aop() {
        throw new RuntimeException("运行时异常");
    }
}
