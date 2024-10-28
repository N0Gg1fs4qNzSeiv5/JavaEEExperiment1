package xyz.djma.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xyz.djma.pojo.Result;
import xyz.djma.pojo.User;
import xyz.djma.service.UserService;
import xyz.djma.service.impl.UserServiceImpl;
import xyz.djma.util.ServletUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * 用于登陆的Servlet
 */
@WebServlet("/api/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取参数
        String param = ServletUtil.getHttpServletRequestFromJson(req);

        // 调用Service
        Gson gson = new Gson();
        Map<String, String> map = gson.fromJson(param, Map.class);
        User user = new User();
        user.setUsername(map.get("username"));
        user.setPassword(map.get("password"));
        UserService userService = new UserServiceImpl();
        Result resul = userService.login(user);

        // 设置响应
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json = gson.toJson(resul);
        resp.getWriter().write(json);
    }
}
