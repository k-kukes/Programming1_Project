import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    public void testIsPostalCodeValid1() {
        String postalCode = "A2C5D6";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid2() {
        String postalCode = "A2C 5D6";
        boolean expectedResult = true;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid3() {
        String postalCode = "A2CD6";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid4() {
        String postalCode = "A11 516";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid5() {
        String postalCode = "A21516";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid6() {
        String postalCode = "";
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testIsPostalCodeValid7() {
        String postalCode = null;
        boolean expectedResult = false;
        boolean result = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expectedResult, result);
    }
}
