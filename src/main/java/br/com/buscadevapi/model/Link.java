package br.com.buscadevapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINK_ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    private LinkType linkType;
    private String link;
    @ManyToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User user;
}
