package com.demo.repository;


import com.demo.pojo.ClaimData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    @Insert("Insert into orders ('user_id', 'deal_id', 'item_bought') " +
            "values ('#{claimData.user_id}, #{claimData.dealId}, #{claimData.itemBought}') ")
    int claimDeal(@Param("claimData") ClaimData claimData);
}
