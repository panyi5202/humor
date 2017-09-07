package cc.youqu8.chapter1.session.defaults;

import cc.youqu8.chapter1.executor.Executor;
import cc.youqu8.chapter1.executor.SimpleExecutor;
import cc.youqu8.chapter1.session.Configuration;
import cc.youqu8.chapter1.session.SqlSession;
import cc.youqu8.chapter1.session.SqlSessionFactory;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        final Executor executor = new SimpleExecutor(configuration);// 执行器可以支持扩展，配置到xml中
        return new DefaultSqlSession(configuration, executor);
    }
}
