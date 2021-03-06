package br.com.buscadevapi.model.composite;

import lombok.Data;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class UserProjectLikeKey implements Serializable {
    @Column(name = "USER_ID")
    private Long developerId;
    @Column(name = "PROJECT_ID")
    private Long projectId;
}
