package xyz.djma.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.djma.pojo.Message;
import xyz.djma.pojo.User;

import java.util.List;

/**
 * 用于操作User的mapper层
 */
public interface UserMapper {
    /**
     * 注册
     * @param user 用户对象
     * @return int
     */
    int register(User user);

    /**
     * 登陆
     * @param user 用户对象
     * @return User
     */
    User login(User user);

    /**
     * 根据id获取用户
     * @param id 用户id
     * @return User
     */
    User getUserById(@Param("id") int id);
}
