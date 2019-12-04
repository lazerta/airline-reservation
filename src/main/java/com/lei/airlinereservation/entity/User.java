package com.lei.airlinereservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    private String airLineManage;


}
