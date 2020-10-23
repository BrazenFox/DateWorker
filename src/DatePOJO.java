public class DatePOJO {
    private final int year;
    private final int month;
    private final int day;

    public DatePOJO(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
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
        return this.year == obj1.year && this.month == obj1.month && this.day == obj1.day;
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
