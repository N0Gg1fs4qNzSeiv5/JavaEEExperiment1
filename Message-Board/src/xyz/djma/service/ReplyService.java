package xyz.djma.service;

import xyz.djma.pojo.Reply;
import xyz.djma.pojo.Result;

/**
 * 用于操作Reply的service
 */
public interface ReplyService {
    Result addReply(Reply reply);
}
