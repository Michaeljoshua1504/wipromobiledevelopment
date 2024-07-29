fun main() {
    val eventManager = EventManager()

    val event1 = Event("UTK Conference", "2024-07-19", 150)
    val specialEvent = SpecialEvent(
        "Celeb Event",
        "2024-07-19",
        123,
        listOf("Michael", "Joshua"),
        listOf("Catering", "VIP Lounge")
    )

    eventManager.addEvent(event1)
    eventManager.addEvent(specialEvent)

    eventManager.showEventDetails(event1)
    eventManager.showEventDetails(specialEvent)

    println("All Events: ${eventManager.listEvents()}")
}
