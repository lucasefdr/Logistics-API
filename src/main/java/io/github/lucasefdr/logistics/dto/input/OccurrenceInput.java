package io.github.lucasefdr.logistics.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInput {
    @NotBlank
    private String description;
}
