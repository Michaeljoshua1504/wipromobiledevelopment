open class Event(val name: String, val date: String, val attendeeCount: Int)

class SpecialEvent(
    name: String,
    date: String,
    attendeeCount: Int,
    val vipList: List<String>,
    val premiumServices: List<String>
) : Event(name, date, attendeeCount)
