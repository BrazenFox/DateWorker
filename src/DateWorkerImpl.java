public class DateWorkerImpl implements DateWorker {

    @Override
    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else return true;
        } else return false;
    }

    @Override
    public boolean isValidDate(int year, int month, int day) {

        return false;
    }

    @Override
    public int getDayOfWeek(int year, int month, int day) {
        return 0;
    }

    @Override
    public String toString(int year, int month, int day) {
        return null;
    }

    @Override
    public int countDays(int year, int month, int day) {
        return 0;
    }
}
