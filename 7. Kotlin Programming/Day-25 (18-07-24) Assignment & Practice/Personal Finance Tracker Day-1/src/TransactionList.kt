class TransactionList {
    private val transactions = mutableListOf<Transaction>()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    fun editTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
        val index = transactions.indexOf(oldTransaction)
        if (index != -1) {
            transactions[index] = newTransaction
        }
    }

    fun listTransactions(): List<Transaction> = transactions.toList()
}
