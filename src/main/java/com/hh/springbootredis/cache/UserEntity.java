package com.hh.springbootredis.cache;

import java.io.Serializable;

/**
 * @author HaoHao
 * @date 2018/8/23下午3:17
 */
public class UserEntity implements Serializable{

    private static final long serialVersionUID = 7118236701057472795L;

    private Long id;

    private String name;

    private int age;

    private String pwd;


    public UserEntity() {
    }

    public UserEntity(Long id, String name, int age, String pwd) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
