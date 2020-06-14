package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;
import org.springframework.data.domain.Page;

@Value
public class LinkDTO {
    @JsonIgnore
    private Long id;
    private String type;
    private String link;
    @JsonIgnore
    private Long userId;

    public LinkDTO(Link link) {
        this.id = link.getId();
        this.type = link.getLinkType().toString();
        this.link = link.getLink();
        this.userId = link.getUser().getId();
    }

    public static Page<LinkDTO> convertPage(Page<Link> linksByUser) {
        return linksByUser.map(LinkDTO::new);
    }

    public static LinkDTO convert(Link link) {
        return new LinkDTO(link);
    }
}
