package com.nekromant.zoo.controller.rest;

import com.nekromant.zoo.model.AnimalRequest;
import com.nekromant.zoo.service.AnimalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animalRequest")
public class AnimalRequestRestController {

    @Autowired
    private AnimalRequestService animalRequestService;

    @PostMapping
    public AnimalRequest newRequest(@RequestBody AnimalRequest animalRequest) {
        animalRequestService.insert(animalRequest);
        return animalRequest;
    }
}
