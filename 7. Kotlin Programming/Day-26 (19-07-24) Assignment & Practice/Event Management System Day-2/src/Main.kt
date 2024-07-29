import java.time.LocalDate

fun main() {
    // Personal Finance Tracker Example
    println("Personal Finance Tracker Example")
    val transactions = listOf(
        Transaction(50.0, LocalDate.now(), "Groceries"),
        Transaction(30.0, LocalDate.now(), "Movies"),
        Transaction(100.0, LocalDate.now(), "Electricity"),
        Transaction(20.0, LocalDate.now(), "Books")
    )

    for (transaction in transactions) {
        val category = categorizeTransaction(transaction)
        println("Transaction of ${transaction.amount} on ${transaction.date} categorized as: $category")
    }
    println()

    // Event Management System Example
    println("Event Management System Example")
    val name = "Michael"
    val eventName = "EXPO 2024"
    val date = "July 19, 2024"

    println("Welcome, $name!")
    println("You're invited to the $eventName on $date.")
    println("We're excited to have you join us, ${name.uppercase()}!")

    val daysUntilEvent = 5
    println("Only $daysUntilEvent days left until the ${eventName.lowercase()}!")
    println()

    // Second Event Example
    val techConference = Event("Expo 2024", LocalDate.of(2024, 7, 20), 500)
    println("Event: ${techConference.name}")
    println("Date: ${techConference.date}")
    println("Expected Attendees: ${techConference.attendeeCount}")
}
