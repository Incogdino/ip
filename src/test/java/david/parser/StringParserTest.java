package david.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import david.exceptions.DavidInvalidArgumentsException;

public class StringParserTest {
    @Test
    public void parseEmptyString_emptyStringReturned() {
        //driver
        String actual = StringParser.parseStringToCommand("");
        assertEquals("", actual, "Empty string returned when empty string passed");
    }

    @Test
    public void parseRandomValue_pperCaseReturned() {
        //driver
        String actual = StringParser.parseStringToCommand("todo");
        assertEquals("TODO", actual, "Upper case version of input string returned");
    }

    @Test
    public void parseRandomValueWithNumber_upperCaseReturned() {
        //driver
        String actual = StringParser.parseStringToCommand("todo123");
        assertEquals("TODO123", actual, "Upper case version of input string returned with numbers");
    }



    @Test
    public void parseEvent_eventDetailsReturned() throws DavidInvalidArgumentsException {
        String actual = StringParser.parseStringToArguments("todo eat meal");
        assertEquals("eat meal", actual, "event details returned only");
    }

    @Test
    public void parseEventWtihNoDetails_exceptionThrown() {
        DavidInvalidArgumentsException exception =
                assertThrows(DavidInvalidArgumentsException.class, (
                ) -> StringParser.parseStringToArguments("todo "));
        assertEquals("Please enter valid arguments.", exception.showErrorMessage(),
                "Exception is thrown when there is no event details supplied");
    }

    @Test
    public void parseEventWtihNoDetailsAndNoWhiteSpace_exceptionThrown() {
        DavidInvalidArgumentsException exception =
                assertThrows(DavidInvalidArgumentsException.class, (
                ) -> StringParser.parseStringToArguments("todo"));
        assertEquals("Please enter valid arguments.", exception.showErrorMessage(),
                "Exception is thrown when there is no event details supplied");
    }
}
