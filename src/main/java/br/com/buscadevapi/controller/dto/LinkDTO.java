package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Link;
import lombok.Value;
import org.springframework.data.domain.Page;

@Value
public class LinkDTO {
    private String type;
    private String link;
    private Long userId;

    public LinkDTO(Link link) {
        this.link = link.getLink();
        this.type = link.getType();
        this.userId = link.getUser().getId();
    }

    public static Page<LinkDTO> convertMany(Page<Link> links) {
        return links.map(LinkDTO::new);
    }

    public static LinkDTO convertOne(Link link) {
        return new LinkDTO(link);
    }

}
