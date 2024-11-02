package xyz.djma.service;

import xyz.djma.pojo.Result;
import xyz.djma.pojo.User;

/**
 * 用于操作User的Service层
 */
public interface UserService {
    /**
     * 注册
     * @param user 用户对象
     * @return Result
     */
    Result register(User user);

    /**
     * 登陆
     * @param user 用户对象
     * @return Result
     */
    Result login(User user);

    /**
     * 根据id获取用户信息
     * @param id id
     * @return Result
     */
    Result getUserById(int id);
}
