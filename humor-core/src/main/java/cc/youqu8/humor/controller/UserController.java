package cc.youqu8.humor.controller;

import cc.youqu8.humor.dao.BaseMapper;
import cc.youqu8.humor.dao.UserMapper;
import cc.youqu8.humor.entity.PayType;
import cc.youqu8.humor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panyi on 17-8-24.
 * @since V0.0.1
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/select")
    public String select(){
        PayType pt = baseMapper.selectByPrimaryKey(1);
        System.out.println(pt.getPayTypeName());
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println("====="+user.getName());

        /*List<Map<String, String>> maps = userMapper.listByName("宇宇");
        for (Map<String, String> map : maps) {
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                System.out.println(s + "=" + map.get(s));
            }
        }*/
        System.out.println("======================================");
        List<User> users = userMapper.listByAge(6);
        for (User user1 : users) {
            System.out.println(user1.getName());
        }
        return "OK";
    }
}
