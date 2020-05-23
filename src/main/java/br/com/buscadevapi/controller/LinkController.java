package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.LinkDTO;
import br.com.buscadevapi.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @GetMapping
    public Page<LinkDTO> allLinks(@PageableDefault Pageable pageable, @RequestParam Long userId) {
        return LinkDTO.convertPage(linkService.getLinksByUser(pageable, userId));
    }
}
