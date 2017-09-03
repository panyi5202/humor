package cc.youqu8.humor.entity;

import javax.persistence.Id;

/**
 * @author panyi on 17-8-28.
 * @since V0.0.1
 */
public class BaseEntity {
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
