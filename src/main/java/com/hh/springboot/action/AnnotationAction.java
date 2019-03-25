package com.hh.springboot.action;

import com.hh.springboot.annotation.TestAnnotation;
import com.hh.springboot.biz.TestBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午5:46
 */
@Controller
public class AnnotationAction {

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
