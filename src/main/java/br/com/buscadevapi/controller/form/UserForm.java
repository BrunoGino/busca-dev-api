package br.com.buscadevapi.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UserForm {
	@NotBlank
	@Length(max = 50)
	private String firstName;
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

}
