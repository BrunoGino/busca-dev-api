package br.com.buscadevapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "B_USER", uniqueConstraints = @UniqueConstraint(columnNames = {"EMAIL"}))
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long id;
    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(50)", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(50)", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "PROFILE_ID")
    private Profile profile;
    @OneToMany(mappedBy = "user")
    private List<Link> links;
    @OneToMany(mappedBy = "user")
    private List<Experience> experiences;
    @ManyToMany
    @JoinTable(
            name = "USER_SKILL",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SKILL_ID")
    )
    private List<Skill> skills;
    @Column(columnDefinition = "VARCHAR(60)")
    private String email;
    @Column(columnDefinition = "VARCHAR(30)")
    private String cellphone;
    @Column(columnDefinition = "VARCHAR(30)")
    private String telephone;
}