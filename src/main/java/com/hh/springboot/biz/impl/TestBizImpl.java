package com.hh.springboot.biz.impl;

import com.hh.springboot.biz.TestBiz;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/7/15下午5:47
 */

//@Service("testBizImpl")
public class TestBizImpl implements TestBiz {

    @Override
    public void say(String words) {
        System.out.println("她说:" + words);
    }
}
