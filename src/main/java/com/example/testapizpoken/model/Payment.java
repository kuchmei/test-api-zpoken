package com.example.testapizpoken.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Payment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Float amount;

    @JsonBackReference
    @OneToOne(mappedBy = "payment")
    private Invoice invoice;

    @Enumerated(EnumType.STRING)
    private Status status;
}
