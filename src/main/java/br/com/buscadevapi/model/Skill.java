package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Entity
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID", nullable = false)
    private Long id;
    @Column(columnDefinition = "VARCHAR(40)", unique = true)
    private String name;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    @ManyToMany(mappedBy = "skills")
    private List<Project> projects;
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;

    public Skill() {
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    public void addProjectToSkill(Project project) {
        projects.add(project);
    }
}
