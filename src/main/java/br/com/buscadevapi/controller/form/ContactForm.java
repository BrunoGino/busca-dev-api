package br.com.buscadevapi.controller.form;

import br.com.buscadevapi.model.Contact;
import br.com.buscadevapi.model.User;
import br.com.buscadevapi.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class ContactForm {
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String telephone;
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String cellphone;
    @Setter
    @Length(max = 40)
    private String linkedinLink;
    @Setter
    @NotNull
    @NotEmpty
    @Length(max = 40)
    private String email;
    @Setter
    @Length(max = 40)
    private String githubLink;
    @NotNull
    @NotEmpty
    private Long userId;

    public Contact convert(UserRepository userRepository) {
        User user = userRepository.findById(userId).get();
        return new Contact(telephone, cellphone, linkedinLink, email, githubLink, user);
    }

}
