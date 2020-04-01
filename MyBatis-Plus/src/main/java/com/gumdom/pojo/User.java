package com.gumdom.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "user")//如果表名和类名一直 可以省略 不写
public class User implements Serializable {
    @TableId(type = IdType.AUTO)//标识主键,并且主键是自增的
    private Integer userId;
    private String userName;
}
