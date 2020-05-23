package br.com.buscadevapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "B_USER", uniqueConstraints = @UniqueConstraint(columnNames = { "EMAIL" }))
@Data
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
    @OneToMany(mappedBy = "user")
    private List<Experience> experiences;
    private String email;
    private String cellphone;
    private String telephone;
}