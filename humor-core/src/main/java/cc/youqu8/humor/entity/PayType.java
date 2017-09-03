package cc.youqu8.humor.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author panyi on 17-8-27.
 * @since V0.0.1
 */
@Table(name="tpay_type")
public class PayType {
    @Id
    @Column(name = "PayTypeId")
    private Integer PayTypeId;
    @Column(name = "PayTypeName")
    private String PayTypeName;

    public Integer getPayTypeId() {
        return PayTypeId;
    }

    public void setPayTypeId(Integer payTypeId) {
        PayTypeId = payTypeId;
    }

    public String getPayTypeName() {
        return PayTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        PayTypeName = payTypeName;
    }
}
