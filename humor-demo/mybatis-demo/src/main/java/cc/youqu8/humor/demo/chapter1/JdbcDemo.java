package cc.youqu8.humor.demo.chapter1;

import cc.youqu8.humor.demo.mybatis.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 展示jdbc的初始化、执行、返回结果的过程
 * @author panyi on 17-9-3.
 * @since V0.0.1
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        // 获取数据库连接
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://121.42.44.170:3306/hotelms";
        Connection connection = DriverManager.getConnection(url, "root", "abcd1234!@#");
        // 执行sql
        String sql = "select * from tuser where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,1);
        ResultSet rs = ps.executeQuery();
        // 封装返回结果
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            System.out.println(user.toString());
        }

        rs.close();
        ps.close();
        connection.close();
    }
}
