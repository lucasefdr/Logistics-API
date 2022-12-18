package io.github.lucasefdr.logistics.service;

import io.github.lucasefdr.logistics.domain.Delivery;
import io.github.lucasefdr.logistics.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeliveryCompletionService {
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public void toFinish(Long deliveryId) {
        Delivery delivery = findDeliveryById(deliveryId);

        delivery.finished();

        deliveryRepository.save(delivery);
    }


    public Delivery findDeliveryById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found"));
    }
}
