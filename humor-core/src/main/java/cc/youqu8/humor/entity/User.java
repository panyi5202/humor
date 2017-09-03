package cc.youqu8.humor.entity;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author panyi on 17-8-28.
 * @since V0.0.1
 */
@Table(name="tuser")
public class User extends BaseEntity{
    @Id
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
}
