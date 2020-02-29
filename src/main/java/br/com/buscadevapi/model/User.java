package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "PROFILE_ID")
    private Profile profile;
    @OneToOne(mappedBy = "user")
    private Contact contact;
    @OneToMany(mappedBy = "owner")
    private List<Project> projectList;
    @OneToMany
    private List<Experience> experiences;
    @ManyToMany
    @JoinTable(
            name = "USER_SKILL",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
    private List<Skill> skills;

    public User(String firstName, String lastName, LocalDate birthDate, String gender, List<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.projectList = projects;
    }

}
