package xyz.djma.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xyz.djma.pojo.Result;
import xyz.djma.service.MessageService;
import xyz.djma.service.impl.MessageServiceImpl;
import xyz.djma.util.LocalDateTimeAdapter;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 用于获取留言的Servlet
 */
@WebServlet("/api/get-all-message")
public class GetAllMessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用service
        MessageService messageService = new MessageServiceImpl();
        Result result = messageService.getAllMessage();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

        // 响应
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json = gson.toJson(result);
        resp.getWriter().write(json);
    }
}
