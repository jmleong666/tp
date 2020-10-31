package seedu.address.model.sale;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class QuantityTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Quantity(null));
    }

    @Test
    public void constructor_invalidQuantity_throwsIllegalArgumentException() {
        Integer invalidQuantity = -34;
        assertThrows(IllegalArgumentException.class, () -> new Quantity(invalidQuantity));
    }

    @Test
    public void isValidQuantity() {
        // null quantity
        assertThrows(NullPointerException.class, () -> Quantity.isValidQuantity(null));

        // invalid quantity
        assertFalse(Quantity.isValidQuantity(-1)); // negative number
        assertFalse(Quantity.isValidQuantity(0)); // zero
        assertFalse(Quantity.isValidQuantity(10000000)); // 10 million
        assertFalse(Quantity.isValidQuantity(10000001)); // 10 million + 1


        // valid quantity
        assertTrue(Quantity.isValidQuantity(12345)); // numbers only
        assertTrue(Quantity.isValidQuantity(1)); // one
        assertTrue(Quantity.isValidQuantity(9999999)); // 10 million - 1
    }
}
