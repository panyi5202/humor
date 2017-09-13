package cc.youqu8.chapter0;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 表示和数据库的一次会话
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public class SqlSession {
    private final Configuration configuration;
    private Connection connection;
    private final Executor executor;

    public SqlSession(Configuration configuration,Executor executor) {
        this.connection = configuration.getConnection();
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statement, Object parameter) throws SQLException {
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statement);
        List<T> list = executor.<T>query(mappedStatement,parameter);
        return list.get(0);
    }
    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public <T> T getMapper(Class<T> type){
        return configuration.getMapper(type, this);
    }
}
