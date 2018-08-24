package com.hh.springbootredis.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author HaoHao
 * @date 2018/8/23下午3:19
 */
@Service
public class UserServiceImpl implements UserService {

    private static UserEntity userEntity;

    static {
        userEntity = new UserEntity(1L, "Kobe", 23, "123321");
    }

    @Override
    @Cacheable(value = "userCache", key = "'user_'+#name")
    public UserEntity getUser(String name) {
        System.out.println("无缓存~ 查询数据库");
        return userEntity;
    }

    // beforeInvocation: 方法执行之前清除缓存
    @Override
    @CacheEvict(value = "userCache",key =  "'user_'+#userEntity.name",beforeInvocation = true)
    public void updateUser(UserEntity userEntity) {
        UserServiceImpl.userEntity = userEntity;
    }

}
