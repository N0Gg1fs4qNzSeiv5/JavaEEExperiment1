package xyz.djma.service;

import xyz.djma.pojo.Message;
import xyz.djma.pojo.Result;

import java.util.List;

/**
 * 用于操作Message的Service层
 */
public interface MessageService {
    /**
     * 获取所有的Message
     * @return List
     */
    Result getAllMessage();
}
