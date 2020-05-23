package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Experience;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

@Value
public class ExperienceDTO {
    @JsonIgnore
    private Long id;
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endDate;
    @JsonIgnore
    private Long userId;

    public ExperienceDTO(Experience experience) {
        this.id = experience.getId();
        this.title = experience.getTitle();
        this.description = experience.getDescription();
        this.initialDate = experience.getInitialDate();
        this.endDate = experience.getEndDate();
        this.userId = experience.getUser().getId();
    }

    public static Page<ExperienceDTO> convertPage(Page<Experience> experiences) {
        return experiences.map(ExperienceDTO::new);
    }

}
