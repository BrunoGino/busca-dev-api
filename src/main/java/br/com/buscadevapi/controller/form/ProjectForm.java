package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.Status;
import br.com.buscadevapi.repository.SkillRepository;
import br.com.buscadevapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectForm {
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 40)
    private String title;
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 10)
    private String endingDate;
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 10)
    private String initialDate;
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 200)
    private String description;
    @Setter
    @NotNull
    @NotEmpty
    private List<Long> skills;
    @Setter
    @NotNull
    @NotEmpty
    private String status;
    @Setter
    private Long userId;

    public Project convert(UserRepository userRepository, SkillRepository skillRepository) {
        return new Project(title, LocalDate.parse(endingDate), LocalDate.parse(initialDate), description
                , skillRepository.findAllByIdIn(skills), Status.valueOf(status), userRepository.findById(userId).get());
    }

}
