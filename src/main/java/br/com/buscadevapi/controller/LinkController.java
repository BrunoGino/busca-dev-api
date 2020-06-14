package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.LinkDTO;
import br.com.buscadevapi.controller.form.LinkForm;
import br.com.buscadevapi.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @GetMapping
    public Page<LinkDTO> allLinksByUser(@PageableDefault Pageable pageable, @RequestParam Long userId) {
        return LinkDTO.convertPage(linkService.getLinksByUser(pageable, userId));
    }

    @PostMapping
    public LinkDTO createNewLink(@RequestBody @Valid LinkForm linkForm) {
        return LinkDTO.convert(linkService.createLink(linkForm));
    }

    @PutMapping
    public LinkDTO updateLink(@RequestBody @Valid LinkForm linkForm) {
        return LinkDTO.convert(linkService.updateLink(linkForm));
    }

    @DeleteMapping(value = "{/linkId}")
    public ResponseEntity<?> deleteLink(@PathVariable @NotBlank Long linkId) {
        return linkService.deleteLink(linkId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
