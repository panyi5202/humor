package cc.youqu8.chapter1;

import cc.youqu8.chapter1.session.SqlSession;
import cc.youqu8.chapter1.session.SqlSessionFactory;
import cc.youqu8.chapter1.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class MybatisDemo {
    public static void main(String[] args) {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
