package adapter;

public class Main {
    public static void main(String[] args) {
        CalendarToNewDateAdapter date = new CalendarToNewDateAdapter();

        date.setDay(15);
        date.setMonth(4);
        date.setYear(2026);

        System.out.println("Date set to: " + date.getDay() + "." + date.getMonth() + "." + date.getYear());

        System.out.println();
        date.advanceDays(20);
        System.out.println("Advancing days:");
        System.out.println("Date advanced: " + date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }
}