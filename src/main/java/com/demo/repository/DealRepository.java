package com.demo.repository;

import com.demo.pojo.ClaimData;
import com.demo.pojo.DealItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DealRepository {

    @Insert("Insert into deal ('deal_name', 'price', 'item_count', 'expiry_time') values ('#{dealItem.dealName}, #{dealItem.price}, #{dealItem.itemCount}, #{dealItem.expiryTime}') ")
    int createDeal(@Param("dealItem") DealItem dealItem);

    @Select("Select * from deal")
    List<DealItem> getAllDeals();

    @Update("Update deal set expiry_time=#{dealItem.expiryTime}, item_count=#{dealItem.itemCount} where id=#{dealItem.id}")
    int updateDeal(@Param("dealItem") DealItem dealItem);

    @Select("Select * from deal where deal_id=#{dealId}")
    DealItem getDealById(@Param("dealId") Integer dealId);

    @Select("Select * from orders where user_id=#{userId} and deal_id=#{dealId}")
    Integer getOrderByDealId(@Param("userId") Integer userId, @Param("dealId") Integer dealId);
}
