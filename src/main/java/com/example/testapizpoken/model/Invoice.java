package com.example.testapizpoken.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Invoice extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Float amount;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoice_status;

    @JsonBackReference
    @OneToOne(mappedBy = "invoice")
    private Deal deal;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;
}
