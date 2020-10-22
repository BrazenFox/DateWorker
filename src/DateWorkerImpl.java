public class DateWorkerImpl implements IDateWorker {

    @Override
    public boolean isLeapYear(int year) {
        if (year > 0) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    return year % 400 == 0;
                } else return true;
            } else return false;
        } else
            throw new IllegalArgumentException("Уear cannot be negative");
    }

    @Override
    public boolean isValidDate(int year, int month, int day) {
        if ((month >= 1 && month <= 12) && (day >= 1 && day <= 31) && year > 0) {
            if (isLeapYear(year) && month == 2) {
                return day <= 29;
            } else return day <= (28 + (month + Math.floor(month / 8.0)) % 2 + 2 % month + 2 * Math.floor(1.0 / month));
        }
        return false;
    }

    @Override
    public int getDayOfWeek(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            if (month < 3) {
                --year;
                month += 10;
            } else
                month -= 2;
            return ((day + 31 * month / 12 + year + year / 4 - year / 100 + year / 400 - 1) % 7);
        } else
            throw new IllegalArgumentException("No such date exists");
    }


    @Override
    public String toString(int year, int month, int day) {
        if (isValidDate(year, month, day))
            return DayOfWeek.values()[getDayOfWeek(year, month, day)].dayString + " " + (day < 10 ? "0" + day : day) + " " + Month.values()[month - 1].getMonth() + " " + year;
        else
            throw new IllegalArgumentException("No such date exists");
    }

    @Override
    public int countDays(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            long today = System.currentTimeMillis();
            today = (int) Math.floor((3 + today / 1000. / 60. / 60.) / 24.);
            int dayFromStart = 0;
            for (int i = 0; i < Math.abs(1970 - year); i++) {
                if (this.isLeapYear(1970 + i))
                    dayFromStart += 366;
                else
                    dayFromStart += 365;
            }
            for (int i = 0; i < month - 1; i++) {
                if (this.isLeapYear(year) && i == 1)
                    dayFromStart += Month.values()[i].getDays() + 1;
                else dayFromStart += Month.values()[i].getDays();
            }
            dayFromStart += day - 1;
            return (int) Math.abs(today-dayFromStart);
        } else
            throw new IllegalArgumentException("No such date exists");
    }
}
