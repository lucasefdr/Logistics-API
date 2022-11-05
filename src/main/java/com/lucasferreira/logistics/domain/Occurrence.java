package com.lucasferreira.logistics.domain;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Delivery delivery;

    private String description;
    private OffsetDateTime registerDate;
}
