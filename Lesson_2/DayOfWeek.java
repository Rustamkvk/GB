package Lesson_2;


    public enum DayOfWeek {
        MONDAY(8),
        TUESDAY(8),
        WEDNESDAY(8),
        THURSDAY(8),
        FRIDAY(8),
        SATURDAY(0),
        SUNDAY(0);

        private int hour;

        public int getHour() {
            return hour;
        }

        DayOfWeek(int hour) {
            this.hour = hour;
        }
    }

