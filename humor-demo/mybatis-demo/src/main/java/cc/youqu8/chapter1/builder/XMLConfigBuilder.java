package cc.youqu8.chapter1.builder;


import cc.youqu8.chapter1.datasource.unpooled.UnpooledDataSource;
import cc.youqu8.chapter1.parsing.XNode;
import cc.youqu8.chapter1.parsing.XPathParser;
import cc.youqu8.chapter1.session.Configuration;
import cc.youqu8.chapter1.session.Environment;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * 根据mybatis-config.xml初始化配置
 *
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public class XMLConfigBuilder {
    private final Configuration configuration;
    private final XPathParser parser;

    public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        this.configuration = new Configuration();
        this.parser = new XPathParser(inputStream);
    }

    public Configuration parse() {
        parseConfiguration(parser.evalNode("/configuration"));
        return configuration;
    }

    private void parseConfiguration(XNode root) {
        try {
            environmentsElement(root.evalNode("environments"));
            mapperElement(root.evalNode("mappers"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mapperElement(XNode mappers) {
        for (XNode node : mappers.getChildren()) {
            String resource = node.getStringAttribute("resource");

        }
    }

    private void environmentsElement(XNode context) throws Exception {
        if (context != null) {
            /*if (environment == null) {
                environment = context.getStringAttribute("default");
            }*/
            for (XNode child : context.getChildren()) {
                String id = child.getStringAttribute("id");
                // TransactionFactory txFactory = transactionManagerElement(child.evalNode("transactionManager"));
                XNode ds = child.evalNode("dataSource");
                Properties props = ds.getChildrenAsProperties();
                DataSource dataSource = new UnpooledDataSource(props.getProperty("url"), props.getProperty("driver"),
                        props.getProperty("username"), props.getProperty("password"));
                configuration.setEnvironment(new Environment(dataSource));
            }
        }
    }
}
