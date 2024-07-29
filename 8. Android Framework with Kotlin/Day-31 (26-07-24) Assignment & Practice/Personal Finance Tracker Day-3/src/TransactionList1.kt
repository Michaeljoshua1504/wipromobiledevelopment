import java.time.LocalDate

data class Transactions(val date: LocalDate, val amount: Double, val description: String)

class TransactionList1 {
    val transactions = mutableListOf<Transaction>()
    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }
}

class User(private val username: String, private val password: String) {
    private var loggedIn = false
    val transactionList = TransactionList()

    fun login(enteredPassword: String) {
        if (enteredPassword == password) {
            loggedIn = true
            println("Login successful")
        } else {
            println("Incorrect password")
        }
    }

    fun displayExpenseSummary() {
        if (!loggedIn) {
            println("Please log in first")
            return
        }

        val totalExpense = transactionList.transactions
            .filter { it.amount < 0 }
            .sumOf { it.amount }

        println("Total expenses: ₹${Math.abs(totalExpense)}")

        println("Top 5 expenses:")
        transactionList.transactions
            .filter { it.amount < 0 }
            .sortedBy { it.amount }
            .take(5)
            .forEach { println("₹${Math.abs(it.amount)} - ${it.description}") }
    }
}

fun main() {
    val user = User("john_doe", "password123")

    user.displayExpenseSummary() // Should prompt to log in

    user.login("wrongpassword")
    user.login("password123")

    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 1), -7500.0, "Groceries"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 2), -2500.0, "Fuel"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 3), -15000.0, "Rent"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 4), 75000.0, "Salary"))
    user.transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 5), -2250.0, "Dinner"))

    user.displayExpenseSummary()
}
