package cc.youqu8.chapter1.session;

/**
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public interface SqlSession {
    <T> T selectOne(String statement, Object parameter);
}
