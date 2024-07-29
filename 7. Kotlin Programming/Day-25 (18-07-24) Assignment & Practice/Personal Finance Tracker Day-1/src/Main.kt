fun main() {
    val user = User("Michael")
    user.login()

    val transaction1 = Expense(1000.0, "2024-07-18", "Accessories", "Shoes")
    val transaction2 = Income(25000.0, "2024-07-18", "Salary", "Company")

    user.addTransaction(transaction1)
    user.addTransaction(transaction2)

    user.displaySummary()
}
