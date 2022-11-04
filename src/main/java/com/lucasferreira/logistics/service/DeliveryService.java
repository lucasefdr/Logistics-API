package com.lucasferreira.logistics.service;

import com.lucasferreira.logistics.domain.model.Client;
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
    private final ClientService clientService;
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery request(Delivery delivery) {
        Client clientExists = clientService.findById(delivery.getClient().getId());

        delivery.setClient(clientExists);
        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setRequestDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
