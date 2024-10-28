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
        return Result.success("success");
    }
}
