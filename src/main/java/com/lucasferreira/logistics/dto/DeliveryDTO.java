package com.lucasferreira.logistics.dto;

import com.lucasferreira.logistics.domain.StatusDelivery;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {
    private Long id;
    private String clientName;
    private AddresseeDTO addressee;
    private BigDecimal tax;
    private StatusDelivery statusDelivery;
    private OffsetDateTime requestDate;
    private OffsetDateTime completionDate;
}
