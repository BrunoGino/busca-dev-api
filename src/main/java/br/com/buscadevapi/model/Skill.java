package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID")
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    @ManyToMany(mappedBy = "skills")
    private List<Project> projects;
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private Profile profile;
}
