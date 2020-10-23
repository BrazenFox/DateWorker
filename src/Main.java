import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        DateWorkerImpl date = new DateWorkerImpl();
        DatePOJO dateP = new DatePOJO(2020, 10, 6);
        System.out.println(date.getDayOfWeek(dateP));
        System.out.println(date.toString(dateP));
        System.out.println(date.countDays(dateP));
        GregorianCalendar c = new GregorianCalendar(1903, Calendar.FEBRUARY,129);// перенос на 1 марта
        System.out.println(c.getTime());
        DatePOJO date1 = new DatePOJO(1903,2,129);
        System.out.println(date1.toString());
    }
}
