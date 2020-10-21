public class Main {
    public static void main(String[] args) {
        DateWorkerImpl date = new DateWorkerImpl();
        System.out.println(date.getDayOfWeek(2020, 10, 5));
        System.out.println(date.toString(2020, 10, 21));
    }
}
