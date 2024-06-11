package com.demo.pojo;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClaimData {
    private Integer userId;
    private Integer dealId;
    private Integer itemCount;
}
