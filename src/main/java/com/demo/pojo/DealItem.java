package com.demo.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DealItem {
    private Long id;
    private String dealName;
    private Double price;
    private Integer itemCount;
    private Date expiryTime;
}
