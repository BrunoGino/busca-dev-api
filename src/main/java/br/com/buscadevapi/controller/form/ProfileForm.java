package br.com.buscadevapi.controller.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class ProfileForm {
	@Length(max = 40)
	@NotBlank
	private String name;
	@NotBlank
	private String description;
}
