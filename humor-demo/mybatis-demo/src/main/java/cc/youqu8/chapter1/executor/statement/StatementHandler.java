package cc.youqu8.chapter1.executor.statement;


import cc.youqu8.chapter1.executor.result.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public interface StatementHandler {
    <E> List<E> query(Statement statement, ResultHandler resultHandler)
            throws SQLException;

    Statement prepare(Connection connection);
}
