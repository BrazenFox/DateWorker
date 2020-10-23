public class DateWorkerImpl implements IDateWorker {


    @Override
    public boolean isLeapYear(int year) {
        if (year > 0) {
            return (year % 4 == 0 && ((year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)));
        } else
            throw new IllegalArgumentException("Уear cannot be negative");
    }

    @Override
    public boolean isValidDate(DatePOJO date) {
        if ((date.getMonth() >= 1 && date.getMonth() <= 12) && (date.getDay() >= 1 && date.getDay() <= 31) && date.getYear() > 0) {
            if (isLeapYear(date.getYear()) && date.getMonth() == 2) {
                return date.getDay() <= 29;
            } else
                return date.getDay() <= (28 + (date.getMonth() + Math.floor(date.getMonth() / 8.0)) % 2 + 2 % date.getMonth() + 2 * Math.floor(1.0 / date.getMonth()));
        }
        return false;
    }

    @Override
    public int getDayOfWeek(DatePOJO date) {
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        if (isValidDate(date)) {
            if (date.getMonth() < 3) {
                --year;
                month += 10;
            } else
                month -= 2;
            return ((day + 31 * month / 12 + year + year / 4 - year / 100 + year / 400 - 1) % 7);
        } else
            throw new IllegalArgumentException("No such date exists");
    }

    @Override
    public String toString(DatePOJO date) {
        if (isValidDate(date))
            return DayOfWeek.values()[getDayOfWeek(date)].dayString + " " + date.toString();
        else
            throw new IllegalArgumentException("No such date exists");
    }

    @Override
    public int countDays(DatePOJO date) {
        if (isValidDate(date)) {
            long today = System.currentTimeMillis();
            today = (int) Math.floor((3 + today / 1000. / 60. / 60.) / 24.);
            System.out.println(today);
            int dayFromStart = 0;
            for (int i = 0; i < Math.abs(1970 - date.getYear()); i++) {
                dayFromStart += this.isLeapYear(1970 + i) ? 366 : 365;
            }
            for (int i = 0; i < date.getMonth() - 1; i++) {
                dayFromStart += Month.values()[i].getDays() + (this.isLeapYear(date.getYear()) && i == 1 ? 1 : 0);
            }
            dayFromStart += date.getDay() - 1;
            System.out.println(dayFromStart);
            return (int) (date.getYear() > 1970 ? Math.abs(today - dayFromStart) : Math.abs(today + dayFromStart));
        } else
            throw new IllegalArgumentException("No such date exists");
    }
}
