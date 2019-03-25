package com.hh.springboot.action;

import com.hh.springboot.model.GolfGTI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/4/28下午11:16
 */
@Controller
@RequestMapping("test")
public class TestAction {

    @Autowired
    private GolfGTI golfGTI;

    @GetMapping(value = "t1")
    String test(Model model) {
        model.addAttribute("name", "张国荣");
        System.out.println(golfGTI.toString());
        return "pages/login";
    }

    @RequestMapping(value = "getData")
    @ResponseBody
    Map<String, Object> ajax() {
        Map<String, Object> response = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("张学友");
        list.add("张国荣");
        list.add("黎明");
        list.add("郭富城");
        response.put("data", list);
        return response;
    }

    @RequestMapping(value = "getAnimal")
    @ResponseBody
    Map<String, Object> getAnimal() {
        Map<String, Object> response = new HashMap<>();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bird","Fly"));
        animals.add(new Animal("Fish","Swim"));
        response.put("data", animals);
        return response;
    }

    static class Animal {

        private String type;

        private String skill;

        public Animal() {
        }

        public Animal(String type, String skill) {
            this.type = type;
            this.skill = skill;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }
    }
}
