package org.udemy;

import org.udemy.service.payment.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.sendPayments(500);
    }
}