package com.demo.mysql.mapper;

import com.demo.mysql.entity.PO.MemberPO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {

    void insert(MemberPO memberPO);
}
