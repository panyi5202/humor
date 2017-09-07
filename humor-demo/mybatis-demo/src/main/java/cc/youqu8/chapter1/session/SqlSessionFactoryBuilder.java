package cc.youqu8.chapter1.session;



import cc.youqu8.chapter1.builder.XMLConfigBuilder;
import cc.youqu8.chapter1.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author panyi on 17-9-3.
 * @since V0.0.1
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream) {
        return build(inputStream, null, null);
    }
    public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
        try {
            XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);
            return build(parser.parse());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                // Intentionally ignore. Prefer previous error.
                e.printStackTrace();
            }
        }
        return null;
    }
    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
