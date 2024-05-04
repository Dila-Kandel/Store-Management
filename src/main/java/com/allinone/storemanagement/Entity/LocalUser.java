package com.allinone.storemanagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;


import java.util.List;

@Entity
@Builder
@Table(name = "local_user")
public class LocalUser{

    /**
     * Unique id for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * The username of the user.
     */
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    /**
     * The encrypted password of the user.
     */
    @JsonIgnore
    @Column(name = "password", nullable = false, length = 1000)
    private String password;
    /**
     * The email of the user.
     */
    @Column(name = "email", nullable = false, unique = true, length = 320)
    private String email;
    /**
     * The first name of the user.
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;
    /**
     * The last name of the user.
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;
    /**
     * The addresses associated with the user.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Address> addresses;

}