package cc.youqu8.chapter1.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 创建datasource的工厂接口
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public interface DataSourceFactory {
    void setProperties(Properties props);

    DataSource getDataSource();
}
