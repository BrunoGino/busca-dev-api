package br.com.buscadevapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "profile")
    private List<User> user;
}
