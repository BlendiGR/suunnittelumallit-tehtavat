package adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private java.util.Calendar calendar;

    public CalendarToNewDateAdapter() {
        this.calendar = Calendar.getInstance(); {
        };
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
        System.out.println("Day set to: " + day);
    }

    @Override
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month -1);
        System.out.println("Month set to: " + month);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
        System.out.println("Year set to: " + year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
