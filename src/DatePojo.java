public class DatePojo {
    int year;
    int month;
    int day;

    public DatePojo(int year, int month, int day) {
        //Все арифметические действия в конструкторе предназначены для того, чтобы пользователь мог вводить дату в любом формате и ему не выдавался exception
        //Например: 2019.2.29 - 29 февраля в 2019 году не было, поэтому коструктор автоматически создаст дату 2019.3.1 как это делает GregorianCalendar
        int realDay = 0;
        int realYear = 0;
        int realMonth = 0;
        for (int i = 0; i < Math.abs(1970 - year); i++) {
            if ((1970 + i) % 4 == 1)
                realDay += 366;
            else
                realDay += 365;
        }
        for (int i = 0; i < (month - 1); i++) {
            if (year % 4 == 0 && i == 1)
                realDay += Month.values()[i % 12].getDays() + 1;
            else realDay += Month.values()[i % 12].getDays();
        }
        realDay += day - 1;

        while (realDay > ((1970 + realYear) % 4 == 0 ? 366 : 365)) {
            if ((1970 - 1 + realYear) % 4 == 0)
                realDay -= 366;
            else
                realDay -= 365;
            realYear++;
        }

        while (realDay >= ((1970 + realYear) % 4 == 0 && realMonth == 1 ? Month.values()[realMonth].getDays() + 1 : Month.values()[realMonth].getDays())) {
            if ((1970 + realYear) % 4 == 0 && realMonth == 1)
                realDay -= Month.values()[realMonth].getDays() + 1;
            else
                realDay -= Month.values()[realMonth].getDays();
            realMonth++;
        }
        this.day = realDay + 1;
        this.month = realMonth + 1;
        this.year = ((year >= 1970) ? 1970 + realYear : 1970 - realYear);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public int hashCode() {
        int sum = this.getDay() + this.getMonth() + this.getYear();
        int result = 25;
        result = 54 * result + sum;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DatePojo)) {
            return false;
        } else {
            DatePojo obj1 = (DatePojo) obj;
            return obj1.getDay() == this.getDay() && obj1.getMonth() == this.getMonth() && obj1.getYear() == this.getYear();
        }
    }

    @Override
    public String toString() {
        return  (getDay() < 10 ? "0" + getDay() : getDay()) + " " + Month.values()[month - 1].getMonth() + " " + getYear();
    }
}
