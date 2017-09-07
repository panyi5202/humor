package cc.youqu8.chapter1.executor.statement;

import cc.youqu8.chapter1.executor.result.ResultHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class PreparedStatementHandler implements StatementHandler{
    private String sql;

    public PreparedStatementHandler(String sql) {
        this.sql = sql;
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.execute();
        return null;
    }

    @Override
    public Statement prepare(Connection connection) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
