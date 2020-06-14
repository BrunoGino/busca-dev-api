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
    @Column(name = "EXPERIENCE_ID", nullable = false)
    private Long id;
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate initialDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "USER_ID")
    private User user;
}
