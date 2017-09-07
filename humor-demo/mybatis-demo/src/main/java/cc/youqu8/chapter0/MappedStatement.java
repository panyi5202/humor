package cc.youqu8.chapter0;

/**
 * @author panyi on 17-9-7.
 * @since V0.0.1
 */
public class MappedStatement {
    private String resultType;
    private String sql;
    private String mapperType;
    private String methodName;

    public MappedStatement(String resultType, String sql, String mapperType, String methodName) {
        this.resultType = resultType;
        this.sql = sql;
        this.mapperType = mapperType;
        this.methodName = methodName;
    }

    public String getResultType() {
        return resultType;
    }

    public String getSql() {
        return sql;
    }

    public String getMapperType() {
        return mapperType;
    }

    public String getMethodName() {
        return methodName;
    }
}
