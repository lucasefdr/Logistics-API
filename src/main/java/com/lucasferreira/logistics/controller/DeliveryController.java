package com.lucasferreira.logistics.controller;

import com.lucasferreira.logistics.domain.Delivery;
import com.lucasferreira.logistics.dto.DeliveryDTO;
import com.lucasferreira.logistics.dto.input.DeliveryInput;
import com.lucasferreira.logistics.mapper.DeliveryMapper;
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
    private final DeliveryMapper deliveryMapper;

    @PostMapping
    public ResponseEntity<DeliveryDTO> request(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery newDelivery = deliveryMapper.toDelivery(deliveryInput);
        Delivery requestDelivery = deliveryService.request((newDelivery));

        return new ResponseEntity<>(deliveryMapper.toDeliveryDTO(requestDelivery), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> listAll() {
        return ResponseEntity.ok(deliveryMapper.toCollectionDeliveryDTO(deliveryService.listAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliveryDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryMapper.toDeliveryDTO((deliveryService.findById(id))));
    }
}