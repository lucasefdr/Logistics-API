package io.github.lucasefdr.logistics.dto.input;

import lombok.Getter;
import lombok.Setter;

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
