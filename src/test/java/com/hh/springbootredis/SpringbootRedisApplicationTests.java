package com.hh.springbootredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.hh.springbootredis.cache.UserEntity;
import com.hh.springbootredis.cache.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

	@Autowired
	private UserService userService;


	@Test
	public void sel() {
		UserEntity entity = userService.getUser("Kobe");
		System.out.println(JSON.toJSONString(entity));
	}

	@Test
	public void update(){
		UserEntity userEntity = new UserEntity(2L, "Kobe", 29, "333");
		userService.updateUser(userEntity);
	}

}
