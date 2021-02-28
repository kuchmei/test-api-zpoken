package com.example.testapizpoken.controller;

import com.example.testapizpoken.model.Invoice;
import com.example.testapizpoken.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = {"/invoice"})
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping(
            value = "/",
            params = {"deal_id"}
    )
    public Invoice createInvoice(@RequestParam("deal_id") Long deal_id,
                                 @RequestBody Invoice invoice){
    return invoiceService.createInvoice(invoice, deal_id);
    }

    @PutMapping(
            value = "/{invoice_id}",
            params = {"deal_id"}
    )
    public void updateInvoice(@PathVariable("invoice_id") Long invoice_id,
                              @RequestParam("deal_id") Long deal_id){
        invoiceService.updateInvoice(invoice_id, deal_id);
    }

}
