package com.demo.controllers;

import com.demo.pojo.DealItem;
import com.demo.pojo.requests.CreateDealRequest;
import com.demo.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
public class DealController {

    @Autowired
    DealService dealService;

    @PostMapping("")
    public Integer deal(@RequestBody CreateDealRequest request){
        System.out.println(request);
        DealItem dealItem = DealItem.builder()
                .dealName(request.getDealName())
                .price(request.getPrice())
                .itemCount(request.getItemCount())
                .expiryTime(request.getExpiryTime())
                .build();
        return dealService.creatDeal(dealItem);
    }

    @PutMapping("")
    public Integer updateDeal(@RequestBody CreateDealRequest request){
        DealItem dealItem = DealItem.builder()
                .itemCount(request.getItemCount())
                .expiryTime(request.getExpiryTime())
                .build();
        return dealService.updateDeal(dealItem);
    }
}
