package com.lucasferreira.logistics.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// Irá fazer parte da tabela Delivery
@Embeddable
public class Addressee {

    @Column(name = "addressee_name")
    private String name;

    @Column(name = "addressee_street")
    private String street;

    @Column(name = "addressee_district")
    private String district;

    @Column(name = "addressee_number")
    private String number;

    @Column(name = "addressee_complement")
    private String complement;
}
