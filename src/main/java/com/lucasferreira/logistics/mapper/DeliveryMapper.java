package com.lucasferreira.logistics.mapper;

import com.lucasferreira.logistics.domain.Delivery;
import com.lucasferreira.logistics.dto.DeliveryDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DeliveryMapper {

    private final ModelMapper modelMapper;

    public DeliveryDTO toDelivery(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionDelivery(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toDelivery)
                .collect(Collectors.toList());
    }
}
