package com.gumdom.Pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO:接触此对象在内存中封装商品信息
 */
public class Goods implements Serializable {
    private static final long serialVersionUID = -8214423039661406785L;
    private Long id;
    private String name;
    private String remark;
    private Date createdTime;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
