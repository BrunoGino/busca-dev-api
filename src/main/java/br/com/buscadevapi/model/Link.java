package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINK_ID")
    private Long id;
    private String type;
    private String link;
    @ManyToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User user;
}
