package seedu.address.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.Month;
import java.time.Year;

import org.junit.jupiter.api.Test;


public class MonthlyCountDataTest {

    private final MonthlyCountData monthlyCountData =
            new MonthlyCountData(new MonthAndYear(Month.AUGUST, Year.now()), 1);

    @Test
    public void constructor_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MonthlyCountData(null, 1));
    }

    @Test
    public void getCount_valid_success() {
        assertEquals(1, this.monthlyCountData.getCount());
    }

    @Test
    public void equals_valid_success() {
        assertEquals(monthlyCountData, monthlyCountData);

        MonthlyCountData monthlyCountData1 = new MonthlyCountData(new MonthAndYear(Month.AUGUST, Year.now()), 1);
        assertEquals(monthlyCountData, monthlyCountData1);

        monthlyCountData1 = new MonthlyCountData(new MonthAndYear(Month.AUGUST, Year.of(2013)), 1);
        assertNotEquals(monthlyCountData, monthlyCountData1);

        monthlyCountData1 = new MonthlyCountData(new MonthAndYear(Month.AUGUST, Year.now()), 2);
        assertNotEquals(monthlyCountData, monthlyCountData1);

        monthlyCountData1 = new MonthlyCountData(new MonthAndYear(Month.APRIL, Year.now()), 1);
        assertNotEquals(monthlyCountData, monthlyCountData1);

        assertNotEquals(monthlyCountData, null);
    }
}
