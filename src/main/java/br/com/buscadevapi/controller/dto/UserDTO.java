package br.com.buscadevapi.controller.dao;

import br.com.buscadevapi.model.User;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
public class UserDAO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String gender;
    private ProfileDAO profile;
    private ContactDAO contact;
    private List<ProjectDAO> projectList;

    public UserDAO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.birthDate = user.getBirthDate();
        this.gender = user.getGender();
        this.profile = ProfileDAO.convertOne(user.getProfile());
        this.contact = ContactDAO.convertOne(user.getContact());
        this.projectList = ProjectDAO.convert(user.getProjectList());
    }


    public static UserDAO convertOne(User user) {
        return new UserDAO(user);
    }

}
