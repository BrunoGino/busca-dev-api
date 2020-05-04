package br.com.userprofiles.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Value;

@Value
public class ProfileDTO {
	@JsonIgnore
	private Long id;
	private String name;
	private String description;
}
