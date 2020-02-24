package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Experience;
import br.com.buscadevapi.model.Profile;
import br.com.buscadevapi.model.Skill;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.ProfileRepository;
import br.com.buscadevapi.repository.SkillRepository;
import br.com.buscadevapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ProfileForm {
    @Setter @NotNull @NotEmpty
    private String description; // Search if it is a developer or a po
    @Setter @NotNull @NotEmpty
    private List<Long> skills; // search for these in db
    @Setter @NotNull @NotEmpty
    private Long user; //search for the user in db

    public Profile convert(ProfileRepository profileRepository, SkillRepository skillRepository, UserRepository userRepository){
        profileRepository.findByDescription(description);
        skillRepository.findAllByIdIn(skills);
        userRepository.findById(user);
    }

}
