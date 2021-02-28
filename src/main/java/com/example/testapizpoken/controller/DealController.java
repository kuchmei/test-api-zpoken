package com.example.testapizpoken.controller;

import com.example.testapizpoken.model.Deal;
import com.example.testapizpoken.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/deals")
public class DealController {

    private final DealService dealService;

    @GetMapping(
            value = "/",
            params = {"page", "size" }
    )
    public Page<Deal> getDeals (@RequestParam("page") int page,
                                @RequestParam("size") int size) {
       return dealService.getAll(page, size);
    }

    @GetMapping(
            value = "/",
            params = {"clients_ids", "page", "size" }
    )
    public Page<Deal> getDealsWithClientFilter(@RequestParam("clents_ids") Long[] clients_ids,
                                               @RequestParam("page") int page,
                                               @RequestParam("size") int size){
        return dealService.getAll(clients_ids, page, size);
    }

    @GetMapping(
            value = "/",
            params = {"type", "page", "size" }
    )
    public Page<Deal> getDealsWithTypeFilter(@RequestParam("type") String type,
                                             @RequestParam("page") int page,
                                             @RequestParam("size") int size){
        return dealService.getAll(type,page,size);
    }

    @GetMapping(value = "/{id}")
    public Deal getDealById (@PathVariable("id") Long id){
        return dealService.getDeal(id);
    }
}
