package cc.youqu8.chapter1.executor.result;

import cc.youqu8.humor.demo.mybatis.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public class ResultHandler {
    public Object handleResult(PreparedStatement ps){
        try {
            ResultSet rs = ps.getResultSet();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
