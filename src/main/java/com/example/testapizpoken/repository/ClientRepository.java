package com.example.testapizpoken.repository;

import com.example.testapizpoken.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Long> {

    Optional<Client> getClientById(Long id);
}
