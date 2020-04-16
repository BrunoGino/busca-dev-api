package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints =
        @UniqueConstraint(columnNames = {"EMAIL"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "PROFILE_ID")
    private Profile profile;
    @OneToMany(mappedBy = "user")
    private List<Link> link;
    @OneToMany(mappedBy = "owner")
    private List<Project> projectList;
    @OneToMany
    private List<Experience> experiences;
    private String email;
    private String cellphone;
    private String telephone;

    @ManyToMany
    @JoinTable(
            name = "USER_SKILL",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
    private List<Skill> skills;

    public User(String firstName, String lastName, LocalDate birthDate, List<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.projectList = projects;
    }

}
