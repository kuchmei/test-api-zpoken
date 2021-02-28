package com.example.testapizpoken.repository;

import com.example.testapizpoken.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


    Optional<Invoice> findInvoiceById(Long id);
}
