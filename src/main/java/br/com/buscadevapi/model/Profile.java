package br.com.buscadevapi.model;

import br.com.buscadevapi.model.composite.ProfileSkill;
import lombok.Value;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Value
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @OneToMany(mappedBy = "skill")
    private List<ProfileSkill> skills;
    @OneToMany(mappedBy = "profile")
    private List<Experience> experiences;
    @OneToOne(mappedBy = "profile")
    private User user;
}
