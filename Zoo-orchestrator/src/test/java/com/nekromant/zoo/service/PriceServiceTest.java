package com.nekromant.zoo.service;


import com.nekromant.zoo.dao.PriceDAO;
import com.nekromant.zoo.model.AnimalRequest;
import com.nekromant.zoo.model.Price;
import dto.AnimalRequestDTO;

import enums.AnimalType;
import enums.Location;
import enums.RequestStatus;
import enums.RoomType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;


@RunWith(MockitoJUnitRunner.class)
public class PriceServiceTest {
    @InjectMocks
    PriceService priceService;

    @Mock
    PriceDAO priceDAO;

    @Test
    public void calculateTotalPriceDogVipVideoNeedTest() {
        AnimalRequestDTO animalRequestFirst = new AnimalRequestDTO(228L,
                RequestStatus.NEW,
                AnimalType.DOG,
                LocalDate.of(2021,11,11),
                LocalDate.of(2021,11,12),
                RoomType.VIP,
                true,
                "",
                "",
                "",
                "",
                "",
                Location.MOSCOW,
                false
        );


      Mockito.when(priceDAO.findTopByOrderByLastUpdatedDesc()).thenReturn(new Price(1L,100,200,300,500,200,100,50,100,1000,100, LocalDateTime.of(2020,06,21,0,0),1,1));

        int resultFirst = priceService.calculateTotalPrice(animalRequestFirst);
        Assert.assertEquals(resultFirst,1800);
//        Mockito.verify(priceDAO,Mockito.times(1)).findTopByOrderByLastUpdatedDesc();
    }


    @Test
    public void getCalculatedPriceSecond() {

        AnimalRequestDTO animalRequestSecond = new AnimalRequestDTO(
                228L,
                RequestStatus.NEW,
                AnimalType.RODENT,
                LocalDate.of(2021,11,11),
                LocalDate.of(2021,11,14),
                RoomType.COMMON,
                false,
                "",
                "",
                "",
                "",
                "",
                Location.MOSCOW,
                false
        );
        Mockito.when(priceDAO.findTopByOrderByLastUpdatedDesc()).thenReturn(new Price(1L,100,200,300,500,200,100,50,100,1000,100, LocalDateTime.of(2020,06,21,0,0),1,1));

        int resultSecond = priceService.calculateTotalPrice(animalRequestSecond);
        Assert.assertEquals(resultSecond,600);

        //todo сделать независимыми тесты https://trello.com/c/uoo87nHv/61-%D1%80%D0%B0%D0%B7%D0%BE%D0%B1%D1%80%D0%B0%D1%82%D1%8C%D1%81%D1%8F-%D1%81-mockitoverify-times2
//        Mockito.verify(priceDAO,Mockito.times(1)).findTopByOrderByLastUpdatedDesc();
    }


}
