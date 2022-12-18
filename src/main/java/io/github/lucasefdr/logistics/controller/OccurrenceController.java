package io.github.lucasefdr.logistics.controller;

import io.github.lucasefdr.logistics.domain.Delivery;
import io.github.lucasefdr.logistics.domain.Occurrence;
import io.github.lucasefdr.logistics.dto.OccurrenceDTO;
import io.github.lucasefdr.logistics.dto.input.OccurrenceInput;
import io.github.lucasefdr.logistics.mapper.OccurrenceMapper;
import io.github.lucasefdr.logistics.service.OccurrenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/delivery/{id}/occurrence")
@RequiredArgsConstructor
public class OccurrenceController {
    private final OccurrenceService occurrenceService;
    private final OccurrenceMapper occurrenceMapper;

    @GetMapping
    public ResponseEntity<List<OccurrenceDTO>> listAll(@PathVariable Long id) {
        Delivery delivery = occurrenceService.findDeliveryById(id);

        return ResponseEntity.ok(occurrenceMapper.toCollectionOccurrenceDTO(delivery.getOccurrences()));
    }

    @PostMapping
    public ResponseEntity<OccurrenceDTO> register(@PathVariable Long id,
                                                  @Valid @RequestBody OccurrenceInput occurrenceInput) {
        Occurrence registeredOccurrence = occurrenceService.register(id, occurrenceInput.getDescription());
        OccurrenceDTO occurrenceDTO = occurrenceMapper.toOccurrence(registeredOccurrence);

        return new ResponseEntity<>(occurrenceDTO, HttpStatus.CREATED);
    }
}
