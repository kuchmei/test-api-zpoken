package com.example.testapizpoken.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClientType client_type;

    @Column(name = "name", length = 77)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "Client_Deal",
            joinColumns = {@JoinColumn(name = "client_id") },
            inverseJoinColumns = {@JoinColumn(name = "deal_id") }
    )
    Set<Deal> deals = new HashSet<>();
}
