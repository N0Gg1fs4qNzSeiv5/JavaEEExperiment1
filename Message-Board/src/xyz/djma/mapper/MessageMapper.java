package xyz.djma.mapper;

import xyz.djma.pojo.Message;

import java.util.List;

/**
 * 用于操作Message的mapper层
 */
public interface MessageMapper {
    /**
     * 获取所有的Message
     * @return 包含所有Message的List集合
     */
    List<Message> getAllMessage();
}
