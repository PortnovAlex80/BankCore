package com.bankcore.domain

class Account(
    val owner: Person,
    val bill: Bill
) {
    // Example of a method that might be on an account
    fun getBillAmount(): Money {
        return bill.amount
    }

    override fun toString(): String {
        return "Account(owner=$owner, bill=${getBillAmount()})"
    }
}

