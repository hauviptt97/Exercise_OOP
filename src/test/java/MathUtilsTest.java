import junit.framework.TestCase;
import org.junit.Test;
import utils.MathUtils;

public class MathUtilsTest {

    @Test
    public void test_max() {
        TestCase.assertEquals((int) MathUtils.max(12, 3, 4, 6), 12);
        TestCase.assertEquals((int) MathUtils.max(12, 3, 24, 6,32), 32);
        new MathUtils();
    }

}
