package cc.youqu8.humor.demo.mybatis.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author panyi on 17-8-28.
 * @since V0.0.1
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User:id=" + id + "|name=" + name + "|age=" + age;
    }
}
