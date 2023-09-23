import java.util.Calendar;
import java.util.Date;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class test {

    public static void main(String[] args) {
        String d1 = "2022-01-01";
        LocalDate localDate = LocalDate.now();// For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String d2 = localDate.format(formatter);

        if (d1.compareTo(d2) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if (d1.compareTo(d2) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if (d1.compareTo(d2) == 0) {
            System.out.println("Both dates are equal");
        }

        // create a LocalDate object
        LocalDate date = LocalDate.parse("2018-12-24");

        // print instance
        System.out.println("LocalDate before"
                + " adding days: " + date);

        // add 15 days
        LocalDate returnvalue = date.plusDays(62);

        // print result
        System.out.println("LocalDate after "
                + " adding days: " + returnvalue);
    }

}
