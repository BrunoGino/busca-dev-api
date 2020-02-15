package br.com.buscadevapi.model;

import lombok.Value;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Value

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endDate;
    @ManyToOne
    private Profile profile;

    /**
     * Does a calculation that gets the difference between the experience's end-date and initial-date
     * 
     * @return Returns a long that represents the duration in days
     */
    public Long getDuration(){
        return Duration.between(endDate.atStartOfDay(),initialDate.atStartOfDay()).toDays();
    }
}
