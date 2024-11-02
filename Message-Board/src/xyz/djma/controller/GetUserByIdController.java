package xyz.djma.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import xyz.djma.pojo.Result;
import xyz.djma.service.UserService;
import xyz.djma.service.impl.UserServiceImpl;
import xyz.djma.util.LocalDateTimeAdapter;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/api/get-user-by-id")
public class GetUserByIdController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UserService userService = new UserServiceImpl();
        Result result = userService.getUserById(Integer.valueOf(id).intValue());

        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        String json = gson.toJson(result);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
