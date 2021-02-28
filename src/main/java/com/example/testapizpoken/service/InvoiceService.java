package com.example.testapizpoken.service;

import com.example.testapizpoken.model.Invoice;

public interface InvoiceService {

    Invoice createInvoice (Invoice invoice, Long dealId);

    void updateInvoice(Long invoiceId, Long dealId);
}
