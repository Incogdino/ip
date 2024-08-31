package david.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import david.exceptions.DavidInvalidDateTimeException;

/**
 * Date parser class to parse given date into proper LocalDateTime and back to String
 */
public class DateParser extends Parser {

    /**
     * Takes an input date time format in the form of " yyyy-MM-dd HHmm" and parses
     * it into a LocalDateTime instance.
     * @param date String date in " yyyy-MM-dd HHmm"
     * @return LocalDateTime instance
     * @throws DavidInvalidDateTimeException
     */
    public static LocalDateTime getDate(String date) throws DavidInvalidDateTimeException {
        try {
            //format string to remove whitespaces first
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd HHmm");
            LocalDateTime d = LocalDateTime.parse(date, inputFormatter);
            return d;
        } catch (DateTimeParseException e) {
            throw new DavidInvalidDateTimeException();
        }
    }

    /**
     * Converts LocalDateTime instance into a readable output date
     * @param date LocalDateTime
     * @return Formatted string in the form of "HHmm dd MMM yyyy"
     */
    public static String formatOutputDate(LocalDateTime date) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HHmm dd MMM yyyy");
        return date.format(outputFormatter);
    }

    /**
     * Converts LocalDateTime instance into a String format for caching
     * @param date LocalDateTime
     * @return Formatted string in the form of " yyyy-MM-dd HHmm"
     */
    public static String formatCacheDate(LocalDateTime date) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd HHmm");
        return date.format(outputFormatter);
    }
}
