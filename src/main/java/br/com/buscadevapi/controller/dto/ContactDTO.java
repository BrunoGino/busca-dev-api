package br.com.buscadevapi.controller.dao;

import br.com.buscadevapi.model.Contact;
import lombok.Builder;
import lombok.Value;

@Value
public class ContactDAO {
    private String telephone;
    private String cellphone;
    private String linkedinLink;
    private String email;
    private String githubLink;

    public ContactDAO(Contact contact) {
        this.telephone = contact.getTelephone();
        this.cellphone = contact.getCellphone();
        this.linkedinLink = contact.getLinkedinLink();
        this.email = contact.getEmail();
        this.githubLink = contact.getGithubLink();
    }

    public static ContactDAO convertOne(Contact contact) {
        return new ContactDAO(contact);
    }

}
