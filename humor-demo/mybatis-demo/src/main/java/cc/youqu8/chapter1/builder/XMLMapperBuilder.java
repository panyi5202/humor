package cc.youqu8.chapter1.builder;

import cc.youqu8.chapter1.mapping.MappedStatement;
import cc.youqu8.chapter1.parsing.XNode;
import cc.youqu8.chapter1.parsing.XPathParser;
import cc.youqu8.chapter1.session.Configuration;

import java.util.List;

/**
 * @author panyi on 17-9-5.
 * @since V0.0.1
 */
public class XMLMapperBuilder {
    protected final Configuration configuration;
    private final XPathParser parser;
    private final String resource;

    public XMLMapperBuilder(Configuration configuration,XPathParser parser, String resource) {
        this.configuration = configuration;
        this.parser = parser;
        this.resource = resource;
    }
    public void parse() {
        XNode mapper = parser.evalNode("/mapper");
        XNode select = mapper.evalNode("select");
        String resultType = mapper.getStringAttribute("resultType");
        String id = mapper.getStringAttribute("id");
        String sql = select.getStringBody();
        System.out.println(sql);
        MappedStatement statement = new MappedStatement(id, sql, resultType);
        this.configuration.addMappedStatement(id,statement);
    }
}
