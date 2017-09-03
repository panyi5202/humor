package cc.youqu8.humor.dao;

import cc.youqu8.humor.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author panyi on 17-8-27.
 * @since V0.0.1
 */

public interface UserMapper  extends Mapper<User>{
    /*List<Map<String, String>> listByName(String name);*/
    List<User> listByAge(Integer age);
}
