package xyz.djma.mapper;

import xyz.djma.pojo.Reply;

/**
 * 用于操作Reply的mapper层
 */
public interface ReplyMapper {
    /**
     * 添加回复
     * @param reply Reply对象
     * @return 受到影响的行数
     */
    int addReply(Reply reply);
}
