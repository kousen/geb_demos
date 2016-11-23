package gebish

import geb.spock.GebReportingSpec

class GebHomePageSpec extends GebReportingSpec {

    def "can access The Book of Geb via homepage"() {
        when:
        to GebHomePage

        and:
        highlights.jQueryLikeApi.click()

        then:
        sectionTitles == ["Navigating Content", "Form Control Shortcuts"]
        highlights.jQueryLikeApi.selected
    }
}