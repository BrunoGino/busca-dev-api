package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.controller.dto.ExperienceDTO;
import br.com.buscadevapi.controller.dto.LinkDTO;
import br.com.buscadevapi.controller.dto.SkillDTO;
import br.com.buscadevapi.model.Experience;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserForm {
    @NotBlank
    @Length(max = 50)
    private String firstName;
    @NotBlank
    @Length(max = 50)
    private String lastName;
    @NotBlank
    @Length(max = 60)
    private String email;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    @Length(max = 15)
    private String cellphone;
    @NotBlank
    @Length(max = 15)
    private String telephone;
    @NotNull
    private String profileName;
    private List<String> skills;
    private List<ExperienceForm> experiences;
    private List<LinkForm> links;

}
