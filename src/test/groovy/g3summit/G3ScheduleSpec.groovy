package g3summit

import geb.spock.GebReportingSpec

class G3ScheduleSpec extends GebReportingSpec {

    def 'navigate to schedule page'() {
        given:
        G3SummitPage home = to G3SummitPage

        expect:
        home.goToSchedule()
    }
}
