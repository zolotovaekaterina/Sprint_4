import org.junit.Before;
import org.junit.Test;

public class ChromeTest extends ChromeConnection {

    SamokatTestCase testCase;

    @Before
    public void prepare() {
        testCase = new SamokatTestCase(driver);
    }

    @Test
    public void checkTextInQuestionsTest() {
        testCase.checkTextInQuestionsTest();
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
