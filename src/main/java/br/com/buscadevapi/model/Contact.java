package br.com.buscadevapi.model;

import lombok.Value;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Value
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String telephone;
    private String cellphone;
    private String linkedinLink;
    private String email;
    private String githubLink;
    @OneToOne(mappedBy = "contact")
    private User user;
}
