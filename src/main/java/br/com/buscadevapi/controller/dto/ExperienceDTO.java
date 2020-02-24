package br.com.buscadevapi.controller.dao;

import br.com.buscadevapi.model.Experience;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ExperienceDAO {
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endDate;

    public ExperienceDAO(Experience experience) {
        this.title = experience.getTitle();
        this.description = experience.getDescription();
        this.initialDate = experience.getInitialDate();
        this.endDate = experience.getEndDate();
    }

    public static List<ExperienceDAO> convert(List<Experience> experience) {
        return experience.stream().map(ExperienceDAO::new).collect(Collectors.toList());
    }

}
