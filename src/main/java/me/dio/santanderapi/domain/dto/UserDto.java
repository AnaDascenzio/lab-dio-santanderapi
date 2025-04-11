package me.dio.santanderapi.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private AccountDto account;
    private CardDto card;
    private List<FeatureDto> features;
    private List<NewsDto> news;   
}
