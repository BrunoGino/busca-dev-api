package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.converter.LocalDateStringConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDate;

@Value
public class ProjectDTO {
    @JsonIgnore
    private Long id;
    private String title;
    @JsonSerialize(converter = LocalDateStringConverter.class)
    private LocalDate endingDate;
    @JsonSerialize(converter = LocalDateStringConverter.class)
    private LocalDate initialDate;
    private String description;
    private Page<SkillDTO> skills;
    private String status;
    private Long ownerId;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.endingDate = project.getEndingDate();
        this.initialDate = project.getInitialDate();
        this.description = project.getDescription();
        this.skills = SkillDTO.convertPage(new PageImpl<>(project.getSkills()));
        this.status = project.getStatus();
        this.ownerId = project.getOwner().getId();
    }

    public static Page<ProjectDTO> convertPage(Page<Project> projects) {
        return projects.map(ProjectDTO::new);
    }
}
