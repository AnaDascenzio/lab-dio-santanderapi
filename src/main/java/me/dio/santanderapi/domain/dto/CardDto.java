package me.dio.santanderapi.domain.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CardDto {

    private Long id;
    private String number;
    private BigDecimal limit;
}
