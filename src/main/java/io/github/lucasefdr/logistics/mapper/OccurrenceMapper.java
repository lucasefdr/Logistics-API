package io.github.lucasefdr.logistics.mapper;

import io.github.lucasefdr.logistics.domain.Occurrence;
import io.github.lucasefdr.logistics.dto.OccurrenceDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OccurrenceMapper {
    private final ModelMapper modelMapper;

    public OccurrenceDTO toOccurrence(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }

    public List<OccurrenceDTO> toCollectionOccurrenceDTO(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toOccurrence)
                .collect(Collectors.toList());
    }
}
