package cc.youqu8.chapter0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * @author panyi on 17-9-13.
 * @since V0.0.1
 */
public class MapperProxy<T> implements InvocationHandler {
    private final SqlSession sqlSession;
    private final Class type;
    public MapperProxy(SqlSession sqlSession, Class<T> type) {
        this.sqlSession = sqlSession;
        this.type = type;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return execute(method,args);
    }

    public T execute(Method method,Object[] args) {
        try {
            System.out.println(type.getName()+"."+method.getName());
            System.out.println(args[0]);
            return sqlSession.selectOne(type.getName()+"."+method.getName(),args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
