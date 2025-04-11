package me.dio.santanderapi.service.converter;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import me.dio.santanderapi.domain.dto.AccountDto;
import me.dio.santanderapi.domain.dto.CardDto;
import me.dio.santanderapi.domain.dto.FeatureDto;
import me.dio.santanderapi.domain.dto.NewsDto;
import me.dio.santanderapi.domain.dto.UserDto;
import me.dio.santanderapi.domain.model.Account;
import me.dio.santanderapi.domain.model.Card;
import me.dio.santanderapi.domain.model.Feature;
import me.dio.santanderapi.domain.model.News;
import me.dio.santanderapi.domain.model.User;

@Component
public class Converter {

    public UserDto toDto(User entity){
        return UserDto.builder()
        .id(entity.getId())
        .name(entity.getName())
        .account(accountToDto(entity.getAccount()))
        .card(cardToDto(entity.getCard()))
        .features(featureToDtoList(entity.getFeatures()))
        .news(newsToDtoList(entity.getNews()))
        .build(); 
    }

    private AccountDto accountToDto(Account entity){
        return AccountDto.builder()
        .id(entity.getId())
        .agency(entity.getAgency())
        .balance(entity.getBalance())
        .limit(entity.getLimit())
        .number(entity.getNumber())
        .build();
    }

    private CardDto cardToDto(Card entity){
        return CardDto.builder()
        .id(entity.getId())
        .number(entity.getNumber())
        .limit(entity.getLimit())
        .build();
    }

    private FeatureDto featureToDto(Feature entity){
        return FeatureDto.builder()
        .id(entity.getId())
        .description(entity.getDescription())
        .icon(entity.getIcon())
        .build();
    }

    private List<FeatureDto> featureToDtoList(List<Feature> features){
        return features.stream()
        .map(this::featureToDto)
        .collect(Collectors.toList()); 
    }
    
    private NewsDto newsToDto(News entity){
        return NewsDto.builder()
        .id(entity.getId())
        .description(entity.getDescription())
        .icon(entity.getIcon())
        .build();
    }

    private List<NewsDto> newsToDtoList(List<News> news){
        return news.stream()
        .map(this::newsToDto)
        .collect(Collectors.toList()); 
    }
    
}
