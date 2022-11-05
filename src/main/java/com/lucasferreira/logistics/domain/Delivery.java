package com.lucasferreira.logistics.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
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
    // @Valid - validação em cascata
    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull
    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class) // Conversão de validação de group
    private Client client;

    @Embedded
    @Valid
    @NotNull
    private Addressee addressee;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = Access.READ_ONLY) // Não será processado pelo JSON
    private StatusDelivery statusDelivery;

    @NotNull
    private BigDecimal tax;

    @JsonProperty(access = Access.READ_ONLY) // Não será processado pelo JSON
    private OffsetDateTime requestDate;

    @JsonProperty(access = Access.READ_ONLY) // Não será processado pelo JSON
    private OffsetDateTime completionDate;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences;

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

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();

        occurrence.setDescription(description);
        occurrence.setRegisterDate(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }
}
