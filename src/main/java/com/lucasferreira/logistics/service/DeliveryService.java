package com.lucasferreira.logistics.service;

import com.lucasferreira.logistics.domain.model.Client;
import com.lucasferreira.logistics.domain.model.Delivery;
import com.lucasferreira.logistics.domain.model.StatusDelivery;
import com.lucasferreira.logistics.dto.DeliveryDTO;
import com.lucasferreira.logistics.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Transactional
    public Delivery request(Delivery delivery) {
        Client clientExists = clientService.findById(delivery.getClient().getId());

        delivery.setClient(clientExists);
        delivery.setStatusDelivery(StatusDelivery.PENDING);
        delivery.setRequestDate(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }

    public List<Delivery> listAll() {
        return deliveryRepository.findAll();
    }

    public DeliveryDTO findById(Long id) {
        return deliveryRepository.findById(id).map(delivery -> {
                    return modelMapper.map(delivery, DeliveryDTO.class);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery not found"));
    }
}
