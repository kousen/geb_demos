import geb.driver.CachingDriverFactory
import geb.spock.GebSpec

class GebHomepageSpec extends GebSpec {

    def cleanup() {
        CachingDriverFactory.clearCache()
    }

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