package examples.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Работа с датами
 */
public class DateDemo {

    /**
     * Базовые возможности
     */
    @Test
    public void base() {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss  'Era:' G 'TimeZone:' z");
        System.out.println("Текущая дата и время: " + format.format(now.getTime()));
    }

    /**
     * Стандартные шаблоны форматирования даты и времени
     */
    @Test
    public void dateFormat() {
        // Получаем текущую дату и время
        Date now = new Date();

        // See what toString() returns
        System.out.println(" 1. " + now.toString());

        // Next, try the default DateFormat
        System.out.println(" 2. " + DateFormat.getInstance().format(now));

        // And the default time and date-time DateFormats
        System.out.println(" 3. " + DateFormat.getTimeInstance().format(now));
        System.out.println(" 4. " + DateFormat.getDateTimeInstance().format(now));

        // Next, try the short, medium and long variants of the
        // default time format
        System.out.println(" 5. " + DateFormat.getTimeInstance(DateFormat.SHORT).format(now));
        System.out.println(" 6. " + DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now));
        System.out.println(" 7. " + DateFormat.getTimeInstance(DateFormat.LONG).format(now));

        // For the default date-time format, the length of both the
        // date and time elements can be specified. Here are some examples:
        System.out.println(" 8. " + DateFormat.getDateTimeInstance(
                DateFormat.SHORT, DateFormat.SHORT).format(now));
        System.out.println(" 9. " + DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM, DateFormat.SHORT).format(now));
        System.out.println("10. " + DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG).format(now));

    }
}
