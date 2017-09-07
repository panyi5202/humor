package cc.youqu8.chapter1.session;

import cc.youqu8.chapter1.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储所有的配置
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class Configuration {
    protected Environment environment;
    protected Map<String,MappedStatement> mappedStatements = new HashMap<>();

    public void addMappedStatement(String id,MappedStatement mappedStatement){
        this.mappedStatements.put(id,mappedStatement);
    }
    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}
