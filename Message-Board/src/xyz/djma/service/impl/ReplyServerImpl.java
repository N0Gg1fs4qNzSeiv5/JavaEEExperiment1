package xyz.djma.service.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.djma.mapper.ReplyMapper;
import xyz.djma.pojo.Reply;
import xyz.djma.pojo.Result;
import xyz.djma.service.ReplyService;
import xyz.djma.util.MybatisUtil;

public class ReplyServerImpl implements ReplyService {
    @Override
    public Result addReply(Reply reply) {
        SqlSession session = MybatisUtil.getSqlSession();

        String content = reply.getContent();
        if (content == null || content.isEmpty()) {
            return Result.error("内容为空");
        }

        ReplyMapper mapper = session.getMapper(ReplyMapper.class);
        int result = mapper.addReply(reply);
        if (result == 0) {
            return Result.error("添加失败");
        } else {
            session.commit();
        }

        session.close();

        return Result.success("添加成功");
    }
}
