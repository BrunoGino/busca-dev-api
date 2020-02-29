package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Project;
import lombok.Value;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ProjectDTO {
    private String title;
    private LocalDate endingDate;
    private LocalDate initialDate;
    private String description;
    private List<SkillDTO> skills;
    private String status;
    private UserDTO owner;

    public ProjectDTO(Project project) {
        this.title = project.getTitle();
        this.endingDate = project.getEndingDate();
        this.initialDate = project.getInitialDate();
        this.description = project.getDescription();
        this.skills = SkillDTO.convert(project.getSkills());
        this.status = project.getStatus().name();
        this.owner = UserDTO.convertOne(project.getOwner());
    }

    public Long getTotalDuration() {
        return Duration.between(endingDate, initialDate).toDays();
    }

    public static List<ProjectDTO> convert(List<Project> projects) {
        return projects.stream().map(ProjectDTO::new).collect(Collectors.toList());
    }
}
