import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        DateWorkerImpl date = new DateWorkerImpl();
        DatePOJO dateP = new DatePOJO(2050, 10, 6);
        System.out.println(date.isLeapYear(1));
        System.out.println(date.getDayOfWeek(dateP));
        System.out.println(date.toString(dateP));
        System.out.println(date.countDays(dateP));

    }
}
