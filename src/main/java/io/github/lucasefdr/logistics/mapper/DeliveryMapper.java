package io.github.lucasefdr.logistics.mapper;

import io.github.lucasefdr.logistics.domain.Delivery;
import io.github.lucasefdr.logistics.dto.DeliveryDTO;
import io.github.lucasefdr.logistics.dto.input.DeliveryInput;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DeliveryMapper {

    private final ModelMapper modelMapper;

    public DeliveryDTO toDeliveryDTO(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionDeliveryDTO(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toDeliveryDTO)
                .collect(Collectors.toList());
    }

    public Delivery toDelivery(DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
