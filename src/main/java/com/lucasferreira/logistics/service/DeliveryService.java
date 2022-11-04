package com.lucasferreira.logistics.service;

import com.lucasferreira.logistics.domain.model.Delivery;
import com.lucasferreira.logistics.domain.model.StatusDelivery;
import com.lucasferreira.logistics.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery request(Delivery delivery) {
        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setRequestDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
