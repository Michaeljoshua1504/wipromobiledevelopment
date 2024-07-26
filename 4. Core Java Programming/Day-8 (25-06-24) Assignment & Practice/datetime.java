import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class datetime {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        /*System.out.println(LocalDate.now().plusDays(39));
        System.out.println(LocalDate.now().plusMonths(2).minusDays(34).plusWeeks(4));
        System.out.println(LocalTime.now().plusHours(45).plusMinutes(34));
        System.out.println(LocalDateTime.now().plusHours(23).plusMinutes(34));*/

        System.out.println(LocalTime.now(ZoneId.of("Asia/Kolkata")));

        LocalDate.now()
            .datesUntil(LocalDate.of(2024, 7, 15))
            .filter(e -> e.getDayOfWeek()!=DayOfWeek.SATURDAY && e.getDayOfWeek()!=DayOfWeek.SUNDAY)
            .forEach(e -> System.out.println(e.getDayOfMonth()+"-"+e.getDayOfWeek().toString()));
    }
}
