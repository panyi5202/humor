package cc.youqu8.chapter0;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * sql的执行器
 * @author panyi on 17-9-6.
 * @since V0.0.1
 */
public class Executor {
    protected Configuration configuration;

    public Executor(Configuration configuration) {
        this.configuration = configuration;
    }

    public <E>List<E> query(MappedStatement statement,Object param) throws SQLException {
        Connection connection = configuration.getConnection();
        PreparedStatement ps = connection.prepareStatement(statement.getSql()); // statement的创建应该有configuration完成
        ps.setInt(1,(Integer)param); // 参数的设置应该交给参数映射器，从接口的方法中获取参数的类型
        ps.executeQuery();
        try {
            List<E> result = new ArrayList<E>();
            ResultSet rs = ps.getResultSet();
            // 查询结果的处理，应该由专门的resultHandler处理，创建相应的元数据对象、对象创建工厂、类型处理器等
            String resultType = statement.getResultType();
            Class<?> resultClazz = Class.forName(resultType);
            E o = (E)resultClazz.newInstance();
            while(rs.next()){
                Method setId = o.getClass().getMethod("setId", Integer.class);
                int id = rs.getInt("id");
                setId.invoke(o,id);

                Method setName = o.getClass().getMethod("setName", String.class);
                String name = rs.getString("name");
                setName.invoke(o,name);
            }
            result.add(o);
            return result;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
