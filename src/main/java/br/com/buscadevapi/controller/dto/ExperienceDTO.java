package br.com.buscadevapi.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Value;

@Value
public class ExperienceDTO {
	@JsonIgnore
	private Long id;
	private String title;
	private String description;
	private LocalDate initialDate;
	private LocalDate endDate;
	@JsonIgnore
	private Long userId;
}
