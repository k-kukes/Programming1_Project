import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {
    @Test
    public void testToTitleCase1() {
        String str = "KUKES KANTHASAMY";
        String expectedResult = "Kukes Kanthasamy";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase2() {
        String str = "kukes kanthasamy";
        String expectedResult = "Kukes Kanthasamy";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testToTitleCase3() {
        String str = "";
        String expectedResult = "";
        String result = Util.toTitleCase(str);

        Assertions.assertEquals(expectedResult, result);
    }

}
