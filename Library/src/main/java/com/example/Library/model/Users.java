package com.example.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private Date birthdate;
    private String username;
    private String password;
    private Timestamp create_time;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id_role"))
    private Collection<Role> roles;
}
