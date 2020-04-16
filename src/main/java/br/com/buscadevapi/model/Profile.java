package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "profile")
    private List<Skill> skills;
    @OneToMany(mappedBy = "profile")
    private List<User> user;

    public Profile(String description, List<Skill> skills, List<User> user) {
        this.description = description;
        this.skills = skills;
        this.user = user;
    }


}
