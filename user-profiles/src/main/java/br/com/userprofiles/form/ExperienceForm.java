package br.com.userprofiles.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ExperienceForm {
	@NotBlank
	@Length(max = 40)
	private String title;
	@NotBlank
	@Length(max = 120)
	private String description;
	@NotNull
	private LocalDate initialDate;
	@NotNull
	private LocalDate endDate;
	private Long userId;
}
