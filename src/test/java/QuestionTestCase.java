import org.junit.Before;
import org.junit.Test;

public class QuestionTestCase extends BrowserConnection{

    DataForTest testCase;

    @Before
    public void prepare() {
        testCase = new DataForTest(driver);
    }

    @Test
    public void checkTextInQuestionsTest() {
        testCase.checkTextInQuestionsTest();
    }

}
