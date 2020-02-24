package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.Status;
import br.com.buscadevapi.repository.SkillRepository;
import br.com.buscadevapi.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
public class ProjectForm {
    @Setter
    private String title;
    @Setter
    private String endingDate;
    @Setter
    private String initialDate;
    @Setter
    private String description;
    @Setter
    private List<Integer> skills;
    @Setter
    private String status;
    @Setter
    private Long userId;

    public Project convert(UserRepository userRepository, SkillRepository skillRepository) {
        return new Project(title, LocalDate.parse(endingDate), LocalDate.parse(initialDate), description
                , skillRepository.findAllByIdIn(skills), Status.valueOf(status), userRepository.findById(userId).get());
    }

}
