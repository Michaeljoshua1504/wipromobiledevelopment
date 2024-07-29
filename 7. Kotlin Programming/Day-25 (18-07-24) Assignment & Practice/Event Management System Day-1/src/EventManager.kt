interface Display {
    fun showEventDetails(event: Event)
}

class EventManager : Display {
    private val events = mutableListOf<Event>()

    fun addEvent(event: Event) {
        events.add(event)
    }

    fun removeEvent(event: Event) {
        events.remove(event)
    }

    fun listEvents(): List<Event> = events.toList()

    override fun showEventDetails(event: Event) {
        println("Event Details: ${event.name} on ${event.date} with ${event.attendeeCount} attendees.")
    }
}

