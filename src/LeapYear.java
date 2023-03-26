public class LeapYear {
    private static final int LEAP_YEAR_DIVISOR = 0;

	public static boolean isLeapYear(int year) {
        if (year % LEAP_YEAR_DIVISOR == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}