import com.bankcore.domain.*
import com.bankcore.usecase.DepositBillPaymentService
import com.bankcore.usecase.PayBillPaymentService
import com.bankcore.usecase.TransferPaymentService

fun main(args: Array<String>) {
    println("Hello World!")

    // Создаем двух людей
    val person1 = Person(PersonName.from("Alice"), PersonAge.from(25))
    val person2 = Person(PersonName.from("Bob"), PersonAge.from(30))

    // Создаем счета для этих людей с некоторым количеством денег
    val bill1 = Bill(Money.from(1000, Currency.USD, Denomination.DOLLARS))
    val bill2 = Bill(Money.from(500, Currency.USD, Denomination.DOLLARS))

    val account1 = Account(person1, bill1)
    val account2 = Account(person2, bill2)

    println("Initial state:")
    println(account1)
    println(account2)

    // Создаем экземпляр сервиса для перевода денег
    val transferPaymentService = TransferPaymentService()

    // Переведем деньги с одного счета на другой
    val transferAmount = Money.from(200, Currency.USD, Denomination.DOLLARS)

    transferPaymentService.transferPayment(account1, account2, transferAmount)

    println("After transfer:")
    println(account1)
    println(account2)

    // Используем службу оплаты для оплаты счета из аккаунта 1
    val payBillPaymentService = PayBillPaymentService()
    val paymentAmount = Money.from(200, Currency.USD, Denomination.DOLLARS)

    payBillPaymentService.payFromAccount(account1, paymentAmount)

    println("After payment:")
    println(account1)

    val depositBillPaymentService = DepositBillPaymentService()

    depositBillPaymentService.depositToAccount(account1, paymentAmount)
    println("After deposit:")
    println(account1)
}