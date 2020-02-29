package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.util.Objects;

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

    public Link(String link, User user) {
        this.user = user;
    }

}
