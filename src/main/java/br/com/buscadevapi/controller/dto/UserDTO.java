package br.com.buscadevapi.controller.dto;

import java.time.LocalDate;

import br.com.buscadevapi.model.User;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

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

	public UserDTO(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.birthDate = user.getBirthDate();
		this.profileType = user.getProfile().getName();
		this.email = user.getEmail();
		this.cellphone = user.getCellphone();
		this.telephone = user.getTelephone();
	}

	public static Page<UserDTO> convertPage(Page<User> users) {
		return users.map(UserDTO::new);
	}

}
