public class DatePOJO {
    private final int year;
    private final int month;
    private final int day;

    public DatePOJO(int year, int month, int day) {
        //Все арифметические действия в конструкторе предназначены для того, чтобы пользователь мог вводить дату в любом формате и ему не выдавался exception
        //Например: 2019.2.29 - 29 февраля в 2019 году не было, поэтому коструктор автоматически создаст дату 2019.3.1 как это делает GregorianCalendar
        int realDay = 0;
        int realYear = 0;
        int realMonth = 0;
        for (int i = 0; i < Math.abs(1970 - year); i++) {
            realDay += (1970 + i) % 4 == 1 ? 366 : 365;
        }
        for (int i = 0; i < (month - 1); i++) {
            realDay += Month.values()[i % 12].getDays() + ((year % 4 == 0 && i == 1) ? 1 : 0);
        }
        realDay += day - 1;

        while (realDay > ((1970 + realYear) % 4 == 0 ? 366 : 365)) {
            realDay -= (1970 - 1 + realYear) % 4 == 0 ? 366 : 365;
            realYear++;
        }

        while (realDay >= ((1970 + realYear) % 4 == 0 && realMonth == 1 ? Month.values()[realMonth].getDays() + 1 : Month.values()[realMonth].getDays())) {
            realDay -= Month.values()[realMonth].getDays() + ((1970 + realYear) % 4 == 0 && realMonth == 1 ? 1 : 0);
            realMonth++;
        }
        this.day = realDay + 1;
        this.month = realMonth + 1;
        this.year = ((year >= 1970) ? 1970 + realYear : 1970 - realYear);
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DatePOJO obj1 = (DatePOJO) obj;
        return year == obj1.year &&
                month == obj1.month &&
                day == obj1.day;
    }

    @Override
    public int hashCode() {
        int sum = this.getDay() + this.getMonth() + this.getYear();
        int result = 25;
        result = 54 * result + sum;
        return result;
    }

    @Override
    public String toString() {
        return (getDay() < 10 ? "0" + getDay() : getDay()) + " " + Month.values()[month - 1].getMonth() + " " + getYear();
    }
}
