package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    @Setter
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String firstName;
    @Setter
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String lastName;
    @Setter
    @NotNull
    @NotEmpty
    @Size(max = 10)
    private LocalDate birthDate;
    @Setter
    @NotNull
    @NotEmpty
    private String gender;

    public User convert() {
        List<Project> projects = new ArrayList<>();
        return new User(firstName, lastName, birthDate, projects);
    }

}
