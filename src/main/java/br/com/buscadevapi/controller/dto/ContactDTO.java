package br.com.buscadevapi.controller.dto;

import br.com.buscadevapi.model.Contact;
import lombok.Value;

@Value
public class ContactDTO {
    private String telephone;
    private String cellphone;
    private String linkedinLink;
    private String email;
    private String githubLink;

    public ContactDTO(Contact contact) {
        this.telephone = contact.getTelephone();
        this.cellphone = contact.getCellphone();
        this.linkedinLink = contact.getLinkedinLink();
        this.email = contact.getEmail();
        this.githubLink = contact.getGithubLink();
    }

    public static ContactDTO convertOne(Contact contact) {
        return new ContactDTO(contact);
    }

}
