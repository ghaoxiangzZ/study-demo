package com.demo.mysql.entity.PO;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberPO implements Serializable {

    private Integer id;
    private String name;
    private Integer gender;
}
