package g3summit

import geb.spock.GebReportingSpec
import spock.lang.Unroll

class G3SchedulePageSpec extends GebReportingSpec {
    @Unroll
    def 'check schedule page for #day'() {
        given:
        to G3SchedulePage

        expect:
        getDailyTitle(day).contains(day)

        where:
        day << G3SchedulePage.days
    }
}
