package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACT_ID")
    private long id;
    private String telephone;
    private String cellphone;
    private String linkedinLink;
    private String email;
    private String githubLink;
    @OneToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User user;

    public Contact(String telephone, String cellphone, String linkedinLink, String email, String githubLink, User user) {
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.linkedinLink = linkedinLink;
        this.email = email;
        this.githubLink = githubLink;
        this.user = user;
    }

}
