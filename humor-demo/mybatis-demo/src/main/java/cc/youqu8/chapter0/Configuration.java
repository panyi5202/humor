package cc.youqu8.chapter0;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置类，保存从mybatis-config.xml和所有的mapper.xml中解析出来的环境信息
 * 包括后续的MappedStatement、Environment、ParameterHandler、ResultHandler等都是从这个类发散出去的
 *
 * @author panyi on 17-9-6.
 * @since V0.0.1
 */
public class Configuration {
    private Connection connection;
    private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();
    private final Map<Class<?>, MapperProxy<?>> knownMappers = new HashMap<Class<?>, MapperProxy<?>>();

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void addMappedStatemte(String key, MappedStatement mappedStatement) {
        this.mappedStatementMap.put(key, mappedStatement);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, type);
        return (T) Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},mapperProxy);
    }
}
