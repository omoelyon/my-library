package com.adeola.libraryapp.mylibrary.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String username;

    private String password;

    private String roles;

    public String getRoles() {
        return "ROLE_USER";
    }

    public void setRoles(String roles) {

        this.roles = "ROLE_USER";
    }
}
