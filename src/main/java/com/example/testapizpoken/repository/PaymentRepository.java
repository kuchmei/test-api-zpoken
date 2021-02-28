package com.example.testapizpoken.repository;

import com.example.testapizpoken.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findPaymentById(Long id);
}
