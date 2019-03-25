package com.hh.springboot.action;

import com.hh.springboot.aop.Log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午10:32
 */
@Controller
public class AOPAction {

    @RequestMapping("aop")
    @ResponseBody
    @Log(operateType = "test",operateName = "测试AOP")
    public String  aop() {
        throw new RuntimeException("运行时异常");
    }
}
