package com.hh.springbootredis.controller;

import javax.annotation.Resource;

import com.hh.springbootredis.annotation.TestAnnotation;
import com.hh.springbootredis.biz.TestBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午5:46
 */
@Controller
public class TestController {

    /**
     * 当有多个实现类时候,使用@Qualifier 或者 @Resource 指明实现类
     *
     * @Resource 是J2ee 提供的 优先根据name 来匹配, 匹配不到则根据类型匹配
     * @Autowired 根据类型匹配, 需跟@Qualifier 配合使用
     */
    @Resource(name = "copyTestBizImpl")
    private TestBiz testBiz;

//    @Autowired
//    @Qualifier("copyTestBizImpl")
//    private TestBiz testBiz;

    @ResponseBody
    @RequestMapping("test")
    public String test() {
        testBiz.say("Hello~");
        testAnnotation();
        return "success";
    }

    @TestAnnotation("test")
    private void testAnnotation() {
    }

}
