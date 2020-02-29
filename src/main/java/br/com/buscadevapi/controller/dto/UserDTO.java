package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.*;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

@Value
public class UserDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.gender = user.getGender();
    }

    public static UserDTO convertOne(User user) {
        return new UserDTO(user);
    }

    public static Page<UserDTO> convert(Page<User> users) {
        return users.map(UserDTO::new);
    }

}
