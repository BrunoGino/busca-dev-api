package br.com.buscadevapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPERIENCE_ID")
    private Long id;
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User user;

}
