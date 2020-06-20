package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Status;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectForm {
    private String title;
    private String description;
    private LocalDate initialDate;
    private LocalDate endingDate;
    private List<String> skillNames;
    private Status status;
    private Long ownerId;

}
