package com.lucasferreira.logistics.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

// Irá fazer parte da tabela Delivery
@Embeddable
@Data
public class Addressee {

    @NotBlank
    @Column(name = "addressee_name")
    private String name;

    @NotBlank
    @Column(name = "addressee_street")
    private String street;

    @NotBlank
    @Column(name = "addressee_district")
    private String district;

    @NotBlank
    @Column(name = "addressee_number")
    private String number;

    @Column(name = "addressee_complement")
    private String complement;
}
