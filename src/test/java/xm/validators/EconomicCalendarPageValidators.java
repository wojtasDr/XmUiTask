package xm.validators;

import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@Component
public class EconomicCalendarPageValidators {

    public void checkIfActualDateIsSetCorrectly(String actualDateString, String actualDateLabel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd", Locale.ENGLISH);

        LocalDate expectedDate;
        LocalDate actualDate = LocalDate.parse(actualDateString, formatter);

        switch (actualDateLabel) {
            case "Today" -> expectedDate = LocalDate.now();
            case "Tomorrow" -> expectedDate = LocalDate.now().plus(1, ChronoUnit.DAYS);
            case "Next Week" -> expectedDate = LocalDate.now().plus(1, ChronoUnit.WEEKS).with(ChronoField.DAY_OF_WEEK, 1);
            default -> throw new IllegalStateException(String.format("Invalid label was given: %s", actualDateLabel));
        }

        Assertions.assertThat(actualDate).isEqualTo(expectedDate);
    }
}
