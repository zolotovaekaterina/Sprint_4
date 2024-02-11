import org.junit.Before;
import org.junit.Test;

public class OrderTestCase extends BrowserConnection {

    DataForTest testCase;

    @Before
    public void prepare() {
        testCase = new DataForTest(driver);
    }

    @Test
    public void makeOrderTestInBodyTest() {
        testCase.makeOrderTestInBodyTest();
    }

    @Test
    public void makeOrderTestInBodyAnotherData() {
        testCase.makeOrderTestInBodyAnotherData();
    }

    @Test
    public void makeOrderTestInHeaderTest() {
        testCase.makeOrderTestInHeaderTest();
    }
}
