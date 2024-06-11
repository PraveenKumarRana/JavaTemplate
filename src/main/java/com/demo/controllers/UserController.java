package com.demo.controllers;


import com.demo.pojo.DealItem;
import com.demo.pojo.requests.ClaimRequest;
import com.demo.pojo.requests.CreateDealRequest;
import com.demo.pojo.responses.GetDealsResponse;
import com.demo.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
public class UserController {

    @Autowired
    DealService dealService;

    @PostMapping("/claim")
    public Integer dealClaim(@RequestBody ClaimRequest request) throws Exception {
        System.out.println("Claim request: "+ request);
        return dealService.claimDeal(request);
    }

    @GetMapping("")
    public GetDealsResponse getDealList(){
        return dealService.getDeals();
    }
}
