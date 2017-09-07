package cc.youqu8.chapter1.executor;

import cc.youqu8.chapter1.executor.statement.PreparedStatementHandler;
import cc.youqu8.chapter1.executor.statement.StatementHandler;
import cc.youqu8.chapter1.session.Configuration;
import cc.youqu8.chapter1.session.RowBounds;
import cc.youqu8.chapter1.mapping.MappedStatement;
import cc.youqu8.chapter1.executor.result.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class SimpleExecutor implements Executor{
    protected Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler) {
        Statement stmt = null;
        try {
            // Configuration configuration = ms.getConfiguration();
            StatementHandler handler = new PreparedStatementHandler(ms.getSql());
            stmt = prepareStatement(handler);
            return handler.<E>query(stmt, resultHandler);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeStatement(stmt);
        }
        return null;
    }
    private Statement prepareStatement(StatementHandler handler) throws SQLException {
        Statement stmt;
        Connection connection = configuration.getEnvironment().getDataSource().getConnection();
        stmt = handler.prepare(connection);
        // handler.parameterize(stmt);
        return stmt;
    }

    private void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // ignore
            }
        }
    }
}
