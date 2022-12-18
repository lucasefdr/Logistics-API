package io.github.lucasefdr.logistics.controller;

import io.github.lucasefdr.logistics.domain.Delivery;
import io.github.lucasefdr.logistics.dto.DeliveryDTO;
import io.github.lucasefdr.logistics.dto.input.DeliveryInput;
import io.github.lucasefdr.logistics.mapper.DeliveryMapper;
import io.github.lucasefdr.logistics.service.DeliveryCompletionService;
import io.github.lucasefdr.logistics.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final DeliveryMapper deliveryMapper;
    private final DeliveryCompletionService deliveryCompletionService;

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

    @PutMapping("/{id}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long id) {
        deliveryCompletionService.toFinish(id);
    }
}