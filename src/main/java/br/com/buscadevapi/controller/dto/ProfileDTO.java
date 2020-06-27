package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.Optional;

@Value
public class ProfileDTO {
    @JsonIgnore
    private Long id;
    private String name;
    private String description;

    public ProfileDTO(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.description = profile.getDescription();
    }

    public static Page<ProfileDTO> convertPage(Page<Profile> profiles) {
        return profiles.map(ProfileDTO::new);
    }
}
