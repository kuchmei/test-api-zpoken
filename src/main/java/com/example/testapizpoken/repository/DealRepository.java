package com.example.testapizpoken.repository;

import com.example.testapizpoken.model.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DealRepository extends PagingAndSortingRepository<Deal, Long> {

    Optional<Deal> findDealById (Long id);

    Page <Deal> findAll(Pageable pageable);

    Page <Deal> findAllByClientsContaining(Long[] clientsContaining, Pageable pageable);

    Page <Deal> findAllByTypeContaining(String type, Pageable pageable);
}
