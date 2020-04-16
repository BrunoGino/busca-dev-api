package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.LinkDTO;
import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkRepository repository;

    @GetMapping
    public Page<LinkDTO> allLinks(@PageableDefault Pageable pageable) {
        Page<Link> links = repository.findAll(pageable);
        return LinkDTO.convertMany(links);
    }
}
