package cc.youqu8.chapter1.session;

import javax.sql.DataSource;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public final class Environment {
    private final DataSource dataSource;

    public Environment(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }
}
