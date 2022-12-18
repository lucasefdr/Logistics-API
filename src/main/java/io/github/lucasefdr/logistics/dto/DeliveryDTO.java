package io.github.lucasefdr.logistics.dto;

import io.github.lucasefdr.logistics.domain.StatusDelivery;
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
