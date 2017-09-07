package cc.youqu8.chapter1.mapping;

/**
 * 保存sql、参数、返回类型等所有的数据
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public class MappedStatement {
    private String id;
    private String sql;
    private String resultType;

    public MappedStatement(String id, String sql, String resultType) {
        this.id = id;
        this.sql = sql;
        this.resultType = resultType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
