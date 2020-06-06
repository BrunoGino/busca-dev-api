package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

@Value
public class UserDTO {
    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String profileType;
    private String email;
    private String cellphone;
    private String telephone;
    private List<SkillDTO> skills;
    private List<ExperienceDTO> experiences;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.profileType = user.getProfile().getName();
        this.email = user.getEmail();
        this.cellphone = user.getCellphone();
        this.telephone = user.getTelephone();
        this.skills = SkillDTO.convertList(user.getSkills());
        this.experiences = ExperienceDTO.convertList(user.getExperiences());
    }

    public static Page<UserDTO> convertPage(Page<User> users) {
        return users.map(UserDTO::new);
    }

    public static UserDTO convert(User user) {
        return new UserDTO(user);
    }

}
