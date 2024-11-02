package xyz.djma.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import xyz.djma.pojo.Message;
import xyz.djma.pojo.Reply;
import xyz.djma.pojo.Result;
import xyz.djma.service.MessageService;
import xyz.djma.service.ReplyService;
import xyz.djma.service.impl.MessageServiceImpl;
import xyz.djma.service.impl.ReplyServerImpl;
import xyz.djma.util.LocalDateTimeAdapter;
import xyz.djma.util.ServletUtil;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/api/add-reply")
public class AddReplyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取参数
        String param = ServletUtil.getHttpServletRequestFromJson(req);

        // 业务
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        Reply reply = gson.fromJson(param, Reply.class);
        reply.setDatetime(LocalDateTime.now());
        reply.setUserId(Integer.parseInt(userId));

        ReplyService replyService = new ReplyServerImpl();
        Result result = replyService.addReply(reply);

        // 设置响应
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json = gson.toJson(result);
        resp.getWriter().write(json);
    }
}
