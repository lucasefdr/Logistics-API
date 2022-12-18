package io.github.lucasefdr.logistics.service;

import io.github.lucasefdr.logistics.domain.Client;
import io.github.lucasefdr.logistics.domain.Delivery;
import io.github.lucasefdr.logistics.domain.StatusDelivery;
import io.github.lucasefdr.logistics.repository.DeliveryRepository;
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

    public Delivery findById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delivery not found"));
    }
}
