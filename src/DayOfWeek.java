public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednsday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    public final String dayString;

    DayOfWeek(String dayString) {
        this.dayString = dayString;
    }

    public String getDayString() {
        return dayString;
    }
}
