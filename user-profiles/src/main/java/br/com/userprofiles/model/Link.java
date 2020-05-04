package br.com.userprofiles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Link {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LINK_ID")
	private Long id;
	@Enumerated(EnumType.STRING)
	private LinkType linkType;
	private String link;
	@ManyToOne
	@JoinColumn(referencedColumnName = "USER_ID")
	private User user;
}
