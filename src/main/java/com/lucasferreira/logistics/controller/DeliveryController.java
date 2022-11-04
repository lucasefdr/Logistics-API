package com.lucasferreira.logistics.controller;

import com.lucasferreira.logistics.domain.Delivery;
import com.lucasferreira.logistics.dto.DeliveryDTO;
import com.lucasferreira.logistics.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryDTO> request(@Valid @RequestBody Delivery delivery) {
        return new ResponseEntity<>(deliveryService.request(delivery), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> listAll() {
        return ResponseEntity.ok(deliveryService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryService.findById(id));
    }
}