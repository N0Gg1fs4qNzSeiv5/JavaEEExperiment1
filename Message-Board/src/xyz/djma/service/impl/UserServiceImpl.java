package xyz.djma.service.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.djma.mapper.UserMapper;
import xyz.djma.pojo.Result;
import xyz.djma.pojo.User;
import xyz.djma.service.UserService;
import xyz.djma.util.MybatisUtil;

public class UserServiceImpl implements UserService {
    @Override
    public Result register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        if (username == null || username.isEmpty()) {
            return Result.error("用户名为空");
        }
        if (password == null || password.isEmpty()) {
            return Result.error("密码为空");
        }

        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        // 判断用户名是否已经存在
        User selectUser = mapper.getUserByUsername(username);
        if (selectUser != null) {
            return Result.error("用户已存在");
        }

        int row = mapper.register(user);
        if (row == 0) {
            return Result.error("注册失败");
        } else {
            session.commit();;
        }
        session.close();
        return Result.success("success");
    }

    @Override
    public Result login(User user) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User selectUser = mapper.login(user);
        if (selectUser == null) {
            return Result.error("登陆失败");
        }

        session.close();
        return Result.success("success", Integer.valueOf(selectUser.getId()));
    }

    @Override
    public Result getUserById(int id) {
        SqlSession session = MybatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(id);

        if (user == null) {
            return Result.error("用户不存在");
        }

        session.close();
        return Result.success("success", user);
    }
}
