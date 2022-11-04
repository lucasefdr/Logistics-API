package com.lucasferreira.logistics.service;

import com.lucasferreira.logistics.domain.Client;
import com.lucasferreira.logistics.domain.Delivery;
import com.lucasferreira.logistics.domain.StatusDelivery;
import com.lucasferreira.logistics.dto.DeliveryDTO;
import com.lucasferreira.logistics.mapper.DeliveryMapper;
import com.lucasferreira.logistics.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final ClientService clientService;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Transactional
    public DeliveryDTO request(Delivery delivery) {
        Client clientExists = clientService.findById(delivery.getClient().getId());

        delivery.setClient(clientExists);
        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setRequestDate(OffsetDateTime.now());

        deliveryRepository.save(delivery);

        return deliveryMapper.toDelivery(delivery);
    }

    public List<DeliveryDTO> listAll() {
        return deliveryMapper.toCollectionDelivery(deliveryRepository.findAll());
    }

    public DeliveryDTO findById(Long id) {
        return deliveryRepository.findById(id).map(deliveryMapper::toDelivery)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery not found"));
    }
}
