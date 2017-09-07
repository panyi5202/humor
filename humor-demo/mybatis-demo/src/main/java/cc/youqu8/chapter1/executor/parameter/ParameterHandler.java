package cc.youqu8.chapter1.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 参数处理器，设置PreparedStatement的参数
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public interface ParameterHandler {
    Object getParameterObject();

    void setParameters(PreparedStatement ps)
            throws SQLException;
}
