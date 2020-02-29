package br.com.buscadevapi.model.composite;

import br.com.buscadevapi.model.Project;
import br.com.buscadevapi.model.User;
import lombok.Value;

import javax.persistence.*;

@Entity
@Value
public class UserProjectLike {
    @EmbeddedId
    private UserProjectLikeKey userProjectLikeKey;
    private boolean isDevLiked;
    private boolean isProjectLiked;
    @ManyToOne
    @MapsId("USER_ID")
    @JoinColumn(name = "USER_ID")
    private User developer;
    @ManyToOne
    @MapsId("PROJECT_ID")
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
}
