package me.dio.santanderapi.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class BaseItemDto {

    private Long id;
    private String icon;
    private String description;
}
