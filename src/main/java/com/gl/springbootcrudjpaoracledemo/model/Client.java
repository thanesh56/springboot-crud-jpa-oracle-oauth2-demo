package com.gl.springbootcrudjpaoracledemo.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client extends BaseEntity{

    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Role> roles;
    private boolean active;

}
