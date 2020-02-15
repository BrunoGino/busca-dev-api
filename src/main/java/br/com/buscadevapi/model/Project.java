package br.com.buscadevapi.model;

import br.com.buscadevapi.model.composite.ProjectSkill;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;


@Entity
@Value
public class Project {
    @Id
    private Long id;
    private String title;
    private LocalDate endingDate;
    private LocalDate initialDate;
    private String description;
    @OneToMany(mappedBy = "skill")
    private List<ProjectSkill> skills;
    private Status status;
    @ManyToOne
    private User owner;
}
