<<<<<<< HEAD
package DSA_PRBLMS;
public class ManualDaysBetweenDates {
    // Days in months
    static int[] monthDays = {31, 28, 31, 30, 31, 30,
                              31, 31, 30, 31, 30, 31};
    // Check leap year
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // Count total days from 01/01/0000 to given date
    public static int countDays(int d, int m, int y) {
        int days = y * 365 + d;
        // Add days for months passed in current year
        for (int i = 0; i < m - 1; i++) {
            days += monthDays[i];
        }
        // Add leap years
        int leapYears = (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
        days += leapYears;
        // If current year is leap and month > Feb, add 1
        if (m > 2 && isLeap(y)) {
            days += 1;
        }
        return days;
    }

    public static int getDaysBetween(int d1, int m1, int y1, int d2, int m2, int y2) {
        int days1 = countDays(d1, m1, y1);
        int days2 = countDays(d2, m2, y2);
        return Math.abs(days2 - days1);
    }

    public static void main(String[] args) {
        int d1 = 1, m1 = 5, y1 = 2023;
        int d2 = 11, m2 = 7, y2 = 2025;

        int result = getDaysBetween(d1, m1, y1, d2, m2, y2);
        System.out.println("Total days between: " + result);
    }
}
/* calculate from 0.0.0000 to entered year for both, then subract both
=======
package DSA_PRBLMS;
public class ManualDaysBetweenDates {
    // Days in months
    static int[] monthDays = {31, 28, 31, 30, 31, 30,
                              31, 31, 30, 31, 30, 31};
    // Check leap year
    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // Count total days from 01/01/0000 to given date
    public static int countDays(int d, int m, int y) {
        int days = y * 365 + d;
        // Add days for months passed in current year
        for (int i = 0; i < m - 1; i++) {
            days += monthDays[i];
        }
        // Add leap years
        int leapYears = (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
        days += leapYears;
        // If current year is leap and month > Feb, add 1
        if (m > 2 && isLeap(y)) {
            days += 1;
        }
        return days;
    }

    public static int getDaysBetween(int d1, int m1, int y1, int d2, int m2, int y2) {
        int days1 = countDays(d1, m1, y1);
        int days2 = countDays(d2, m2, y2);
        return Math.abs(days2 - days1);
    }

    public static void main(String[] args) {
        int d1 = 1, m1 = 5, y1 = 2023;
        int d2 = 11, m2 = 7, y2 = 2025;

        int result = getDaysBetween(d1, m1, y1, d2, m2, y2);
        System.out.println("Total days between: " + result);
    }
}
/* calculate from 0.0.0000 to entered year for both, then subract both
>>>>>>> master
*/