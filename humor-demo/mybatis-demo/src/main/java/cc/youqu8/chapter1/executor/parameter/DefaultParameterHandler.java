package cc.youqu8.chapter1.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class DefaultParameterHandler implements ParameterHandler{
    @Override
    public Object getParameterObject() {
        return null;
    }

    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {

    }
}
