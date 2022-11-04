package com.lucasferreira.logistics.domain.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitas entregas possuí um cliente
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Embedded
    private Addressee addressee;

    @Enumerated(EnumType.STRING)
    private StatusDelivery statusDelivery;

    private BigDecimal tax;
    private LocalDateTime requestDate;
    private LocalDateTime completionDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Delivery delivery = (Delivery) o;
        return id != null && Objects.equals(id, delivery.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
