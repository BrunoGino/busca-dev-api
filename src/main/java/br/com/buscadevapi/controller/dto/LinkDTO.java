package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Link;
import lombok.Value;

@Value
public class LinkDTO {
    private String type;
    private String link;

    public LinkDTO(Link link) {
       this.link = link.getLink();
       this.type = link.getType();
    }

    public static LinkDTO convertOne(Link link) {
        return new LinkDTO(link);
    }

}
