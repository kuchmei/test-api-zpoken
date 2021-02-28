package com.example.testapizpoken.service;

import com.example.testapizpoken.exception.DealNotFoundException;
import com.example.testapizpoken.model.Deal;
import com.example.testapizpoken.model.InvoiceStatus;
import com.example.testapizpoken.model.Status;
import com.example.testapizpoken.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;

    @Override
    public Deal getDeal(Long id) {
        Deal deal = dealRepository.findDealById(id)
                .orElseThrow(()-> new DealNotFoundException("Deal with id " + id  + "not found"));
     return checkAndSetDataInDeal(deal);
    }

    @Override
    public Page<Deal> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum == null || pageNum < 0 ? 0 : pageNum, pageSize == null || pageSize < 1 ? 10 : pageSize, Sort.Direction.ASC, "id");
        return dealRepository.findAll(pageable);
    }

    @Override
    public Page<Deal> getAll(Long[] clients_ids, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum == null || pageNum < 0 ? 0 : pageNum, pageSize == null || pageSize < 1 ? 10 : pageSize, Sort.Direction.ASC, "id");
        return dealRepository.findAllByClientsContaining(clients_ids,pageable);
    }

    @Override
    public Page<Deal> getAll(String type, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum == null || pageNum < 0 ? 0 : pageNum, pageSize == null || pageSize < 1 ? 10 : pageSize, Sort.Direction.ASC, "id");
        return dealRepository.findAllByTypeContaining(type,pageable);
    }

    private Deal checkAndSetDataInDeal(Deal deal){
        if (deal.getInvoice().getAmount()>deal.getInvoice().getPayment().getAmount()){
            deal.getInvoice().setInvoice_status(InvoiceStatus.NOT_PAID);
            deal.getInvoice().getPayment().setStatus(Status.FAILED);
            return deal;
        } else if (deal.getInvoice().getAmount().equals(deal.getInvoice().getPayment().getAmount())){
            deal.getInvoice().setInvoice_status(InvoiceStatus.PARTIALLY_PAID);
            deal.getInvoice().getPayment().setStatus(Status.ACCEPTED);
            return deal;
        } else {
            deal.getInvoice().setInvoice_status(InvoiceStatus.PAID);
            deal.getInvoice().getPayment().setStatus(Status.ACCEPTED);
            return deal;
        }
    }
}
