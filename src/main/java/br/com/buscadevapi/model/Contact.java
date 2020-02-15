package br.com.buscadevapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String telephone;
    private String cellphone;
    private String linkedinLink;
    private String email;
    private String githubLink;
    @OneToOne(mappedBy = "contact")
    private User user;

    public Contact() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&
                Objects.equals(telephone, contact.telephone) &&
                Objects.equals(cellphone, contact.cellphone) &&
                Objects.equals(linkedinLink, contact.linkedinLink) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(githubLink, contact.githubLink) &&
                user.equals(contact.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, telephone, cellphone, linkedinLink, email, githubLink, user);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
