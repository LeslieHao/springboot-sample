package com.hh.springboot.action;

import com.hh.springboot.model.GolfGTI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HaoHao
 * @date 2019/3/25下午6:34
 */
@Controller
@RequestMapping("car")
public class CarAction {

    private static Logger logger = LoggerFactory.getLogger(CarAction.class);

    @Autowired
    private GolfGTI gti;


    @RequestMapping("drive")
    public String  drive() {
        logger.info(gti.toString());
        return "pages/login";
    }
}
