package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Experience;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ExperienceDTO {
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endDate;

    public ExperienceDTO(Experience experience) {
        this.title = experience.getTitle();
        this.description = experience.getDescription();
        this.initialDate = experience.getInitialDate();
        this.endDate = experience.getEndDate();
    }

    public static List<ExperienceDTO> convert(List<Experience> experience) {
        return experience.stream().map(ExperienceDTO::new).collect(Collectors.toList());
    }

}
