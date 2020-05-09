package br.com.buscadevapi.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Value;

@Value
public class LinkDTO {
	@JsonIgnore
	private Long id;
	private String type;
	private String link;
	@JsonIgnore
	private Long userId;
}
