package com.lei.airlinereservation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lei.airlinereservation.common.Const;
import com.lei.airlinereservation.common.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@Data
@ToString(exclude = "reservations")
@EqualsAndHashCode(exclude = "reservations")
public class User implements Serializable {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "alias")
    private String alias;

    @Column(name = "password")
    private String password;
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    @Column(name = "role")

    private String role = Const.CUSTOMER;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,},fetch = FetchType.LAZY)

    @JoinTable(
            name = "tbl_reservation",
           joinColumns = @JoinColumn(name = "customer_username"),
           inverseJoinColumns = @JoinColumn(name = "flight_id")

    )
    private Set<Flight> reservations;


}
