package com.lucasferreira.logistics.dto.input;

import com.lucasferreira.logistics.domain.Addressee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AddresseeInput {
    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String district;

    @NotBlank
    private String number;

    private String complement;
}
