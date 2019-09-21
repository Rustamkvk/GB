package Lesson_2;

public class DayOfWeekMain {

    public static int getWorkingHours(DayOfWeek dayOfWeek) {
        int result = 0;
        for(int i = dayOfWeek.ordinal(); i < dayOfWeek.values().length; i++ )
            result += dayOfWeek.values()[i].getHour();
        return result;
    }


    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
    }
}