package br.com.buscadevapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINK_ID", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LinkType linkType;
    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String link;
    @ManyToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User user;
}
