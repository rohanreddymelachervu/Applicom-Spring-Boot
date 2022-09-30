package com.Applicom.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;
import javax.persistence.*;

@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ADDRESS",
        joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")
        },
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id")
    )
    private Set<Address> addresses;
}
