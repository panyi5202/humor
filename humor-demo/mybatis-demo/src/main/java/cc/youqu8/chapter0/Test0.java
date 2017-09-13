package cc.youqu8.chapter0;

import cc.youqu8.humor.demo.mybatis.dao.UserMapper;
import cc.youqu8.humor.demo.mybatis.domain.User;

import java.sql.SQLException;

/**
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public class Test0 {
    public static void main(String[] args) throws SQLException {
        // 1.解析mybatis-config.xml,初始化数据库连接和映射元数据
        String resource = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactory(resource);
        SqlSession session = sqlSessionFactory.openSession();
        // 2.获取mapper接口的代理类
         UserMapper mapper = session.getMapper(UserMapper.class);

        // 3.调用接口，传入参数
        User user = mapper.select(1);
        System.out.println(user.getName());
//        User u = session.selectOne("cc.youqu8.humor.demo.mybatis.dao.UserMapper.select", 1);
//        System.out.println(u.getName());
        session.close();
    }
}
