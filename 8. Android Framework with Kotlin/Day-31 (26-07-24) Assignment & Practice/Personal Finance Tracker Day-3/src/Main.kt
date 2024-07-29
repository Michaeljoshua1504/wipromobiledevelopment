import java.time.LocalDate

fun main() {
    // **Scenario 1: Transaction List Management**

    println("Scenario 1: Transaction List Management")
    val transactionList = TransactionList()

    transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 1), 7500.0, "Groceries"))
    transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 2), 2500.0, "Fuel"))
    transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 3), 15000.0, "Rent"))

    println("Initial transactions:")
    transactionList.displayTransactions()

    transactionList.deleteTransaction(1)
    println("\nAfter deleting index 1:")
    transactionList.displayTransactions()

    transactionList.editTransaction(0, Transaction(LocalDate.of(2023, 7, 1), 9000.0, "Groceries and Supplies"))
    println("\nAfter editing index 0:")
    transactionList.displayTransactions()

    // **Scenario 2: User Expense Summary**

    println("\nScenario 2: User Expense Summary")
    val user = User("john_doe", "password123")

    user.displayExpenseSummary() // Should prompt to log in

    user.login("wrongpassword") // Try logging in with the wrong password
    user.login("password123")   // Log in with the correct password

    // Add transactions to the user's transaction list
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 1), -7500.0, "Groceries"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 2), -2500.0, "Fuel"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 3), -15000.0, "Rent"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 4), 75000.0, "Salary"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 5), -2250.0, "Dinner"))

    user.displayExpenseSummary()

    // **Scenario 3: Income and Expense Inheritance**

    println("\nScenario 3: Income and Expense Inheritance")
    val transactions = listOf(
        Income(LocalDate.of(2023, 7, 1), 75000.0, "Salary", "Employment"),
        Expense(LocalDate.of(2023, 7, 2), 2500.0, "Groceries", "Food"),
        Income(LocalDate.of(2023, 7, 3), 15000.0, "Freelance work", "Consulting"),
        Expense(LocalDate.of(2023, 7, 4), 750.0, "Electricity bill", "Utilities")
    )

    println("All transactions:")
    transactions.forEach { println(it) }

    println("\nTotal income: ₹${transactions.filterIsInstance<Income>().sumOf { it.amount }}")
    println("Total expenses: ₹${Math.abs(transactions.filterIsInstance<Expense>().sumOf { it.amount })}")
}
