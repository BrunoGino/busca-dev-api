package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Link;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class LinkForm {
    @Setter
    @NotEmpty
    @Length(max = 50)
    private String link;
    @Setter
    @NotEmpty
    @Length(max = 40)
    private String type;
    @Setter
    @NotNull
    @Length(max = 40)
    private String email;

    public Link convert(UserRepository userRepository) {
        User user = userRepository.findByEmail(email);
        return new Link(link, user);
    }

}
