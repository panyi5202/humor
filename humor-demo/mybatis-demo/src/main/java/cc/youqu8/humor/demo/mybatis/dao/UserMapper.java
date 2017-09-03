package cc.youqu8.humor.demo.mybatis.dao;

import cc.youqu8.humor.demo.mybatis.domain.User;

/**
 * @author panyi on 17-8-29.
 * @since V0.0.1
 */
public interface UserMapper {
    User select(Integer id);
    int insert(User user);
}
