package com.demo.services;

import com.demo.pojo.ClaimData;
import com.demo.pojo.DealItem;
import com.demo.pojo.requests.ClaimRequest;
import com.demo.pojo.responses.GetDealsResponse;
import com.demo.repository.DealRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class DealService {
    @Autowired
    DealRepository dealRepository;
    @Autowired
    UserRepository userRepository;

    public Integer creatDeal(DealItem dealItem) {
        System.out.println("Create deal");
        return dealRepository.createDeal(dealItem);
    }

    public Integer updateDeal(DealItem dealItem) {
        System.out.println("Update deal");
        return dealRepository.updateDeal(dealItem);
    }

    public Integer claimDeal(ClaimRequest request) throws Exception {
        System.out.println("Claim deal");
        validateClaimRequest(request);
        ClaimData claimData = ClaimData.builder()
                .dealId(request.getDealId())
                .dealId(request.getUserId())
                .itemCount(1)
                .build();
        return userRepository.claimDeal(claimData);
    }

    public GetDealsResponse getDeals() {
        System.out.println("Get deals");
        return GetDealsResponse.builder()
                .deals(dealRepository.getAllDeals())
                .build();
    }

    private void validateClaimRequest(ClaimRequest request) throws Exception {
        System.out.println("Validate claim request");
        Date currentDate = new Date();
        DealItem dealItem = dealRepository.getDealById(request.getDealId());
        if(Objects.nonNull(dealItem) && dealItem.getExpiryTime().before(currentDate)) {
            throw new Exception("Deal is Over");
        }
        if(Objects.nonNull(dealItem) && dealItem.getItemCount() == 0) {
            throw new Exception("No item available");
        }
        Integer isBought = dealRepository.getOrderByDealId(request.getUserId(), request.getDealId());
        if(Objects.nonNull(isBought) && isBought == 1) {
            throw new Exception("You have bought this deal once");
        }
    }
}
