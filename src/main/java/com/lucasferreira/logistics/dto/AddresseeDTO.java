package com.lucasferreira.logistics.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddresseeDTO {
    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;
}
