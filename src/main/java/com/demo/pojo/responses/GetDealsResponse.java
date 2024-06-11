package com.demo.pojo.responses;

import com.demo.pojo.DealItem;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class GetDealsResponse {
    List<DealItem> deals;
}
