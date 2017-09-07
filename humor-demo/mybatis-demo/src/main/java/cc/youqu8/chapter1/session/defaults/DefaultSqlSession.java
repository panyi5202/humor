package cc.youqu8.chapter1.session.defaults;

import cc.youqu8.chapter1.executor.Executor;
import cc.youqu8.chapter1.session.Configuration;
import cc.youqu8.chapter1.session.SqlSession;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.util.List;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class DefaultSqlSession implements SqlSession {
    private final Configuration configuration;
    private final Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        List<T> list = this.<T>selectList(statement, parameter);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() > 1) {
            throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        } else {
            return null;
        }
    }
    public <E> List<E> selectList(String statement, Object parameter) {
        return null;
    }
   /* public <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds) {
        try {
            MappedStatement ms = configuration.getMappedStatement(statement);
            return executor.query(ms, wrapCollection(parameter), rowBounds, Executor.NO_RESULT_HANDLER);
        } catch (Exception e) {
            throw ExceptionFactory.wrapException("Error querying database.  Cause: " + e, e);
        } finally {
            ErrorContext.instance().reset();
        }
    }*/
}
