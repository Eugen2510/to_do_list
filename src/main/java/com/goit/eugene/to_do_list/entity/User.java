package com.goit.eugene.to_do_list.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String name;

    @Column (name = "password")
    private String password;

    @Column (name = "role")
    private String role;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Note> notes;
}
