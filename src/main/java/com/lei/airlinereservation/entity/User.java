package com.lei.airlinereservation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tbl_user")
public class User implements Serializable {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "alias")
    private String alias;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


}
