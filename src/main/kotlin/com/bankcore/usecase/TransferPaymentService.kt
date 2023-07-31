package com.bankcore.usecase

import com.bankcore.domain.Account
import com.bankcore.domain.Money

class transferPaymentService {
    fun transferPayment(from: Account, to: Account, paymentAmount: Money) {
        if (from.bill.amount.amount < paymentAmount.amount) {
            throw IllegalArgumentException("Insufficient funds in the source account")
        }

        if (from.bill.amount.currency != to.bill.amount.currency) {
            throw IllegalArgumentException("Cannot transfer money between accounts with different currencies")
        }

        // Subtract payment amount from source account
        from.bill.amount = from.bill.amount.subtract(paymentAmount)

        // Add payment amount to target account
        to.bill.amount = to.bill.amount.add(paymentAmount)
    }
}
