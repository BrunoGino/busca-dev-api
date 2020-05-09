package br.com.buscadevapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

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
