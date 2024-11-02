package xyz.djma.service.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.djma.mapper.MessageMapper;
import xyz.djma.mapper.UserMapper;
import xyz.djma.pojo.Message;
import xyz.djma.pojo.Reply;
import xyz.djma.pojo.Result;
import xyz.djma.service.MessageService;
import xyz.djma.util.MybatisUtil;

import java.time.LocalDateTime;
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

    @Override
    public Result addMessage(Message message) {
        SqlSession session = MybatisUtil.getSqlSession();

        String title = message.getTitle();
        String content = message.getContent();

        if (title == null || title.isEmpty()) return Result.error("标题为空");
        if (content == null || content.isEmpty()) return Result.error("内容为空");

        MessageMapper messageMapper = session.getMapper(MessageMapper.class);
        if(messageMapper.addMessage(message) == 0) {
            return Result.error("添加失败");
        } else {
            session.commit();
        }

        session.close();

        return Result.success("success");
    }
}
