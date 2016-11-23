package g3summit;

import geb.junit4.GebReportingTest
import org.junit.Test

class G3SummitPageTest extends GebReportingTest {
    @Test
    public void g3HomePage() throws Exception {
        via G3SummitPage
        assert at(G3SummitPage)
    }
}