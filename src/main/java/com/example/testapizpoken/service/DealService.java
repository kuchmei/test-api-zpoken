package com.example.testapizpoken.service;

import com.example.testapizpoken.model.Deal;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface DealService {

    Deal getDeal(Long id);

    Page<Deal> getAll (Integer pageNum, Integer pageSize);

    Page <Deal> getAll (Long[] clients_ids, Integer pageNum, Integer pageSize);

    Page <Deal> getAll (String type, Integer pageNum, Integer pageSize);
 }
