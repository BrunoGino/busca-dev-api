package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private Long id;
    private String title;
    private LocalDate endingDate;
    private LocalDate initialDate;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "PROJECT_SKILL",
            joinColumns = @JoinColumn(name = "PROJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
    private List<Skill> skills;
    private String status;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User owner;

    public Project(String title, LocalDate endingDate, LocalDate initialDate, String description
            , List<Skill> skills, Status status, User owner) {
        this.title = title;
        this.endingDate = endingDate;
        this.initialDate = initialDate;
        this.description = description;
        this.skills = skills;
        this.status = status.getDescription();
        this.owner = owner;
    }
}
