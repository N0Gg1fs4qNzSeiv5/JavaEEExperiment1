package xyz.djma.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 与Mybatis相关的工具类
 */
public class MybatisUtil {
    /**
     * 获取一个SqlSession
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        InputStream is = null;

        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new SqlSessionFactoryBuilder().build(is).openSession();
    }
}
