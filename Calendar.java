/**
 * Prints the calendar of a certain year.
 */
public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2; // 1.1.1900 was a Monday
    static int nDaysInMonth = 31; // Number of days in January

    /**
     * Prints the calendar of a received year.
     */
    public static void main(String args[]) {
        // Advances the date and the day-of-the-week from 1/1/1900 till 31/12 of the
        // year received, inclusive.
        // Prints each date dd/mm/yyyy in a separate line of the received year. If the
        // day is a Sunday, prints "Sunday".
        int thisYear = Integer.parseInt(args[0]);

        // Checks that the received year has not passed yet
        while ((thisYear + 1) > year) {

            // Checks that a year is the received year
            if (thisYear == year) {

                // Checks if the day is Sunday
                if (dayOfWeek == 1) {
                    System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
                    if (dayOfMonth == 1) {

                    }
                } else {
                    System.out.println(dayOfMonth + "/" + month + "/" + year);
                }
            }
            advance();
        }
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year,
    // dayOfWeek, nDaysInMonth.
    private static void advance() {

        // Checks if the week is over
        if (dayOfWeek == 7) {
            dayOfWeek = 1;
        } else {
            dayOfWeek++;
        }

        // Checks is the month is over
        if (dayOfMonth == nDaysInMonth) {
            month++;

            // Checks if the year is over
            if (month == 13) {
                month = 1;
                year++;
            }
            nDaysInMonth = nDaysInMonth(month, year);
            dayOfMonth = 1;
        } else {
            dayOfMonth++;
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {

        boolean isLeapYear;

        // Check if the year is divisible by 400
        isLeapYear = ((year % 400) == 0);

        // Then checks if the year is divisible by 4 but not by 100
        isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));

        return isLeapYear;

    }

    // Returns the number of days in the given month and year.
    // April, June, September, and November have 30 days each.
    // February has 28 days in a common year, and 29 days in a leap year.
    // All the other months have 31 days.
    private static int nDaysInMonth(int month, int year) {
        int numberOfDaysInMonth = 0;

        // Checks which month was received and enters the number of days in
        // numberOfDaysInMonth
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numberOfDaysInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numberOfDaysInMonth = 30;
                break;
            case 2:

                // Checks if the year is lean
                if (isLeapYear(year) && month == 2) {
                    numberOfDaysInMonth = 29;
                } else {
                    numberOfDaysInMonth = 28;
                }
                break;
            default:
                numberOfDaysInMonth = 0;
                break;
        }
        return numberOfDaysInMonth;
    }
}
