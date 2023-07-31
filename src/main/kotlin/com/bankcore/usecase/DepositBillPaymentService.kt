package com.bankcore.usecase

import com.bankcore.domain.Account
import com.bankcore.domain.Money

class DepositBillPaymentService {
    fun depositToAccount(from: Account, paymentAmount: Money) {
        incomeToAccount(from, paymentAmount)
    }

    private fun incomeToAccount(account: Account, amount: Money) {
        account.bill.amount = account.bill.amount.add(amount)
    }
}
