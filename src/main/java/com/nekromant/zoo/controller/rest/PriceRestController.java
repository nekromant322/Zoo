package com.nekromant.zoo.controller.rest;

import com.nekromant.zoo.model.AnimalRequest;
import com.nekromant.zoo.model.Price;
import com.nekromant.zoo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/pricePage")
public class PriceRestController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public Price getActualPrice() {
        return priceService.getActualPrice();
    }

    @PostMapping("/calculate")
    public int calculateTotalPriceForRequest(@RequestBody AnimalRequest animalRequest) {
        return priceService.calculateTotalPrice(animalRequest);
    }

    @PostMapping("/new")
    public void newPrice(@RequestBody Price price) {
        priceService.insert(price);
    }

}
