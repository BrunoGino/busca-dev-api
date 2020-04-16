package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Experience;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

@Value
public class ExperienceDTO {
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endDate;
    private Long userId;

    public ExperienceDTO(Experience experience) {
        this.title = experience.getTitle();
        this.description = experience.getDescription();
        this.initialDate = experience.getInitialDate();
        this.endDate = experience.getEndDate();
        this.userId = experience.getUser().getId();
    }

    public static Page<ExperienceDTO> convertMany(Page<Experience> experience) {
        return experience.map(ExperienceDTO::new);
    }

}
