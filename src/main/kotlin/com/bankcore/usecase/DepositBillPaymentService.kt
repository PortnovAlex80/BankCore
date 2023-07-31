package com.bankcore.usecase

import com.bankcore.domain.Account
import com.bankcore.domain.Money

class DepositBillPaymentService {
    fun payFromAccount(from: Account, paymentAmount: Money) {
        subtractFromAccount(from, paymentAmount)
    }

    private fun subtractFromAccount(account: Account, amount: Money) {
        if (account.bill.amount.amount < amount.amount) {
            throw IllegalArgumentException("Insufficient funds in the account")
        }

        // Subtract payment amount from source account
        account.bill.amount = account.bill.amount.subtract(amount)
    }
}
