import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        DateWorkerImpl date = new DateWorkerImpl();
        System.out.println(date.getDayOfWeek(2020, 10, 6));
        System.out.println(date.toString(2020, 10, 21));
        System.out.println(date.countDays(2019, 2, 28));
        GregorianCalendar c = new GregorianCalendar(2019, Calendar.FEBRUARY,29);// перенос на 1 марта
        System.out.println(c.getTime());
        DatePojo date1 = new DatePojo(2019,2,29);
        /*System.out.println(date1.getDay());
        System.out.println(date1.getMonth());
        System.out.println(date1.getYear());*/
        System.out.println(date1.toString());
    }
}
