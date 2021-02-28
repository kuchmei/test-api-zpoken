package com.example.testapizpoken.service;

import com.example.testapizpoken.TestApiZpokenApplication;
import com.example.testapizpoken.exception.DealNotFoundException;
import com.example.testapizpoken.model.Deal;
import com.example.testapizpoken.model.Invoice;
import com.example.testapizpoken.model.InvoiceStatus;
import com.example.testapizpoken.repository.DealRepository;
import com.example.testapizpoken.repository.InvoiceRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class InvoiceServiceImplTest extends TestApiZpokenApplication {

    private final InvoiceRepository invoiceRepository = Mockito.mock(InvoiceRepository.class);
    private final DealRepository dealRepository = Mockito.mock(DealRepository.class);
    private Invoice invoice = Mockito.mock(Invoice.class);
    private Deal deal = Mockito.mock(Deal.class);

    private InvoiceServiceImpl invoiceService = new InvoiceServiceImpl(invoiceRepository,dealRepository);

    @Before


    @Test
    public void updateInvoiceTest(){
        Mockito.when(invoiceRepository.findInvoiceById(Mockito.any())).thenReturn(Optional.of(invoice));
        Mockito.when(dealRepository.findDealById(Mockito.any())).thenReturn(Optional.of(deal));

        invoiceService.updateInvoice(1L,1L);

        verify(invoiceRepository, times(1)).findInvoiceById(any());
        verify(dealRepository, times(2)).findDealById(any());
    }

    @Test
    public void updateInvoice_EmptyDeal(){
        Mockito.when(invoiceRepository.findInvoiceById(Mockito.any())).thenReturn(Optional.of(invoice));
        Mockito.when(dealRepository.findDealById(Mockito.any())).thenThrow(new DealNotFoundException(any()));


        assertThrows(DealNotFoundException.class, ()-> {
            invoiceService.updateInvoice(1L, 1L);
        });
    }

    private void initInvoice(){
        invoice.setId(1L);
        invoice.setInvoice_status(InvoiceStatus.PAID);
        invoice.setAmount(124532F);
        invoice.setDeal(new Deal());
    }

    private void initDeal(){
        deal.setId(1L);
        deal.setInvoice(invoice);
        deal.setType("OK");
        deal.setVolume(232F);
    }
}