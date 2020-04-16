package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.User;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

@Value
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String cellphone;
    private String telephone;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.email = user.getEmail();
        this.cellphone = user.getCellphone();
        this.telephone = user.getTelephone();
    }

    public static UserDTO convertOne(User user) {
        return new UserDTO(user);
    }

    public static Page<UserDTO> convert(Page<User> users) {
        return users.map(UserDTO::new);
    }

}
