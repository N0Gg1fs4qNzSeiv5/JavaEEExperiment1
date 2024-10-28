package xyz.djma.util;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 与Servlet相关的工具类
 */
public class ServletUtil {
    /**
     * 读取Json格式的HttpRequest参数
     * @param request HttpServletRequest
     * @return String
     */
    public static String getHttpServletRequestFromJson(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
