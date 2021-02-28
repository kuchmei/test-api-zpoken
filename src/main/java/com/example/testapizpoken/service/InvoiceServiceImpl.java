package com.example.testapizpoken.service;

import com.example.testapizpoken.exception.DealNotFoundException;
import com.example.testapizpoken.exception.InvoiceNotFoundException;
import com.example.testapizpoken.model.Deal;
import com.example.testapizpoken.model.Invoice;
import com.example.testapizpoken.repository.DealRepository;
import com.example.testapizpoken.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final DealRepository dealRepository;

    @Override
    public Invoice createInvoice(Invoice invoice, Long dealId) {
        Invoice savedInvoice =  invoiceRepository.save(invoice);
        Deal deal = dealRepository.findDealById(dealId)
                .orElseThrow(()-> new  DealNotFoundException ("Deal with id " + dealId + "not exist" ));

        savedInvoice.setDeal(deal);

        return savedInvoice;
    }

    @Override
    public void updateInvoice(Long invoiceId, Long dealId) {
        Invoice invoice = invoiceRepository.findInvoiceById(invoiceId)
                .orElseThrow(()-> new InvoiceNotFoundException("Invoice with id " + invoiceId + " not exist" ));
        if (dealRepository.findDealById(dealId).isPresent()){
            Deal deal = dealRepository.findDealById(dealId).get();
            invoice.setDeal(deal);
        } else {
            throw new DealNotFoundException("Deal with id " + dealId + " not found");
        }
        invoiceRepository.save(invoice);
    }
}
