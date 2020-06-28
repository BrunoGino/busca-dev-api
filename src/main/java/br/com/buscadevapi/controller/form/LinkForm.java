package br.com.buscadevapi.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class LinkForm {
	@NotNull
	private String linkType;
	@NotBlank @Length(max = 70)
	private String link;
	private String userId;
}
