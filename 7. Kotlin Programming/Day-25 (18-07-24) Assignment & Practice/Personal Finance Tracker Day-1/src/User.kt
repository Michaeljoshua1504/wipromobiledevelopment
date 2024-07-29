class User(val name: String) {
    private var loggedIn = false
    private val transactionList = TransactionList()

    fun login() {
        loggedIn = true
        println("User $name logged in.")
    }

    fun addTransaction(transaction: Transaction) {
        transactionList.addTransaction(transaction)
    }

    fun displaySummary() {
        if (loggedIn) {
            println("Transaction summary for $name:")
            transactionList.listTransactions().forEach {
                println("Amount: ${it.amount}, Date: ${it.date}, Category: ${it.category}")
            }
        } else {
            println("User not logged in.")
        }
    }
}
