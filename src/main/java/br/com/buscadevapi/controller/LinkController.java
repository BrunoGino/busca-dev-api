package br.com.buscadevapi.controller;

import br.com.buscadevapi.controller.dto.LinkDTO;
import br.com.buscadevapi.controller.form.LinkForm;
import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;

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
    public ResponseEntity<?> createNewLink(@RequestBody @Valid LinkForm linkForm, UriComponentsBuilder uriComponentsBuilder) {
        try {
            Link link = linkService.createLink(linkForm);
            LinkDTO linkDTO = new LinkDTO(link);
            URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(linkDTO.getId()).toUri();
            return ResponseEntity.created(uri).body(linkDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{linkId}")
    public ResponseEntity<?> updateLink(@RequestBody @Valid LinkForm linkForm, @PathVariable Long linkId) {
        try {
            Link link = linkService.updateLink(linkId, linkForm);
            LinkDTO linkDTO = new LinkDTO(link);
            return ResponseEntity.ok(linkDTO);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{linkId}")
    public ResponseEntity<?> deleteLink(@PathVariable @NotBlank Long linkId) {
        return linkService.deleteLink(linkId) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
