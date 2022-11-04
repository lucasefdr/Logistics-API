package com.lucasferreira.logistics.controller;

import com.lucasferreira.logistics.domain.model.Delivery;
import com.lucasferreira.logistics.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<Delivery> request(@RequestBody  Delivery delivery) {
        return new ResponseEntity<>(deliveryService.request(delivery), HttpStatus.CREATED);
    }
}