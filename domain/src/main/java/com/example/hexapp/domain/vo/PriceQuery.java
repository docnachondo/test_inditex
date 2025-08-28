package com.example.hexapp.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class PriceQuery {

    private Long brandId;
    private Long productId;
    private LocalDateTime applicationDate;
}
