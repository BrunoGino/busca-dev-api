package br.com.buscadevapi.controller.dao;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.Skill;
import br.com.buscadevapi.model.User;
import lombok.Value;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ProjectDAO {
    private String title;
    private LocalDate endingDate;
    private LocalDate initialDate;
    private String description;
    private List<SkillDAO> skills;
    private String status;
    private UserDAO owner;

    public ProjectDAO(Project project) {
        this.title = project.getTitle();
        this.endingDate = project.getEndingDate();
        this.initialDate = project.getInitialDate();
        this.description = project.getDescription();
        this.skills = SkillDAO.convert(project.getSkills());
        this.status = project.getStatus().name();
        this.owner = UserDAO.convertOne(project.getOwner());
    }

    public Long getTotalDuration() {
        return Duration.between(endingDate, initialDate).toDays();
    }

    public static List<ProjectDAO> convert(List<Project> projects) {
        return projects.stream().map(ProjectDAO::new).collect(Collectors.toList());
    }
}
