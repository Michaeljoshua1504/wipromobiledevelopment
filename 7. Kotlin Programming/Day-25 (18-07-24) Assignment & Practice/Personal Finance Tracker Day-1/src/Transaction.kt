open class Transaction(val amount: Double, val date: String, val category: String)

class Income(amount: Double, date: String, category: String, val source: String) : Transaction(amount, date, category)
class Expense(amount: Double, date: String, category: String, val reason: String) : Transaction(amount, date, category)
