package com.hh.springboot.redis.cache;

/**
 * @author HaoHao
 * @Description:
 * @date 2018/8/23下午3:16
 */
public interface UserService {

    UserEntity getUser(String name);

    void updateUser(UserEntity userEntity);
}
