package cc.youqu8.chapter0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public class SqlSessionFactory {
    private final Configuration configuration;

    public SqlSessionFactory(String resource) {
        // 初始化数据库连接
        Connection connection = initDataSource();
        // 解析映射元数据（sql、接口、方法、返回类型）
        String resultType = "cc.youqu8.humor.demo.mybatis.domain.User";
        String sql = "select * from tuser where id = ?"; // 解析的过程中，把参数转成成占位符
        String mapperType = "cc.youqu8.humor.demo.mybatis.dao.UserMapper";
        String methodName = "select";
        MappedStatement mappedStatement = new MappedStatement(resultType, sql, mapperType, methodName);
        configuration = new Configuration();
        configuration.setConnection(connection);
        configuration.addMappedStatemte(mapperType + "." + methodName, mappedStatement);
        // 生成mapper的代理类和方法，生成类是为了面向对象的编程，让代码可读性更好

    }

    private Connection initDataSource() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://121.42.44.170:3306/hotelms";
            Connection connection = DriverManager.getConnection(url, "root", "abcd1234!@#");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SqlSession openSession() {
        final Executor executor = new Executor(configuration);
        return new SqlSession(configuration, executor);
    }
}
