public interface IDateWorker {
    boolean isLeapYear(int year);
    boolean isValidDate(DatePOJO date);
    int getDayOfWeek(DatePOJO date);
    String toString(DatePOJO date);
    int countDays(DatePOJO date);
}
