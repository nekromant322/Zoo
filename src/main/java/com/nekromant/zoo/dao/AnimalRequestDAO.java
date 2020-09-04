package com.nekromant.zoo.dao;

import com.nekromant.zoo.enums.RequestStatus;
import com.nekromant.zoo.model.AnimalRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRequestDAO extends CrudRepository<AnimalRequest, Long> {

    List<AnimalRequest> findAllByRequestStatus(RequestStatus requestStatus);
}