package xyz.djma.service.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.djma.mapper.MessageMapper;
import xyz.djma.mapper.UserMapper;
import xyz.djma.pojo.Message;
import xyz.djma.pojo.Reply;
import xyz.djma.pojo.Result;
import xyz.djma.service.MessageService;
import xyz.djma.util.MybatisUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MessageServiceImpl implements MessageService {
    @Override
    public Result getAllMessage() {
        SqlSession session = MybatisUtil.getSqlSession();
        MessageMapper messageMapper = session.getMapper(MessageMapper.class);
        List<Message> messages = messageMapper.getAllMessage();

        session.close();
        return Result.success("success", messages);
    }
}
