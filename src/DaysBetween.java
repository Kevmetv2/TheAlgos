public class DaysBetween {
    public static void main(String[] args) {
        System.out.println(monthToDays(5));
    }
    public static int countDays(Date d1, Date d2){
        int days1 = monthToDays(d1.month) + yearsToDays(d1.year) + d1.day;
        int days2 = monthToDays(d2.month) + yearsToDays(d2.year) + d2.day;
        if(days1 > days2){
            return days1 - days2;
        }
        return days2 - days1;
    }
    public static int monthToDays(int month){
        int daysTotal = 0;

        for(int i = 1; i < month+1;i++){ // start from 1 if DaysInMonth requires 1
            daysTotal += 31; // would call the DaysInMonth function and add the days
        }

        return daysTotal;
    }
    public static int yearsToDays(int year){
        int daysTotal = 0;
        if(year%4 == 0){ // detected a leap year
            daysTotal += year/4; // amount of leap years that occurred
        }
        daysTotal += year*365;

        return daysTotal;
    }

}

class Date{
    int year;
    int month;
    int day;

    public Date(int year,int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
}