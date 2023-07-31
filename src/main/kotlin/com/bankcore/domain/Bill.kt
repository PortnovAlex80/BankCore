package com.bankcore.domain

class Bill (var amount: Money){
}

data class Money private constructor(
    val amount: Int,
    val currency: Currency,
    val denomination: Denomination
){
companion object {
    fun from(amount: Int, currency: Currency, denomination: Denomination): Money {
        // Add any validation rules here (e.g., ensure non-negative values)
        if (amount < 0) {
            throw IllegalArgumentException("Money amount cannot be negative")
        }

        return Money(amount, currency, denomination)
    }

}

    // Example of custom operations or methods related to money (you can add more as needed)
    fun add(other: Money): Money {
        if (currency != other.currency) {
            throw IllegalArgumentException("Cannot add money of different currencies")
        }
        return Money(amount + other.amount, currency, denomination)
    }

    fun subtract(other: Money): Money {
        if (currency != other.currency) {
            throw IllegalArgumentException("Cannot subtract money of different currencies")
        }
        return Money(amount - other.amount, currency, denomination)
    }

    // Override toString to provide a user-friendly representation of the money amount
    override fun toString(): String {
        return "$amount ${denomination.displayName} ${currency.symbol}"
    }

}

// Enum class to represent currencies
enum class Currency(val symbol: String) {
    USD("$"), // United States Dollar
    RUB("₽") // Russian Ruble (symbol might not display correctly in some environments)
}

// Enum class to represent denominations (dollars/cents or rubles/kopeks)
enum class Denomination(val displayName: String) {
    DOLLARS("dollars"),
    CENTS("cents"),
    RUBLES("rubles"),
    KOPEKS("kopeks")
}