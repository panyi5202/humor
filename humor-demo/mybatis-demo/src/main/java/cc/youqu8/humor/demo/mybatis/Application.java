package cc.youqu8.humor.demo.mybatis;

import cc.youqu8.humor.demo.mybatis.dao.UserMapper;
import cc.youqu8.humor.demo.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author panyi on 17-8-29.
 * @since V0.0.1
 */
public class Application {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.select(1);
            System.out.println(user.getName());
            User user3 = mapper.select(1);
            System.out.println(user3.getName());
            session.commit(); // session commit后，才提交到缓存中
            System.out.println(mapper);

            SqlSession session2 = sqlSessionFactory.openSession();
            UserMapper mapper2 = session2.getMapper(UserMapper.class);
            User user4 = mapper2.select(1);
            System.out.println(user4.getName());
            System.out.println(mapper2);
            /*User user2 = new User();
            user2.setName("安安");
            user2.setAge(3);
            mapper.insert(user2);
            System.out.println(user2.getId());*/
        } finally {
            session.close();
        }
    }
}
