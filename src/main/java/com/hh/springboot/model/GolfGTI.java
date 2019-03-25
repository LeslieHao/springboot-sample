package com.hh.springboot.model;

import com.alibaba.fastjson.JSON;

/**
 * @author HaoHao
 * @date 2019/3/25下午5:37
 */
public class GolfGTI {

    private String name;

    private String engine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}