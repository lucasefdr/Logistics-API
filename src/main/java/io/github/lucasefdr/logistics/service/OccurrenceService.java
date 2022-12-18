package io.github.lucasefdr.logistics.service;

import io.github.lucasefdr.logistics.domain.Delivery;
import io.github.lucasefdr.logistics.domain.Occurrence;
import io.github.lucasefdr.logistics.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class OccurrenceService {
    private final DeliveryRepository deliveryRepository;

    @Transactional
    public Occurrence register(Long deliveryId, String description) {
        Delivery delivery = findDeliveryById(deliveryId);

        return delivery.addOccurrence(description);
    }

    public Delivery findDeliveryById(Long deliveryId) {
        return deliveryRepository.findById(deliveryId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found"));
    }
}
