import geb.Browser
import geb.Page

class RWXHomePage extends Page {
    static url = 'http://therichwebexperience.com'

    static at = { title == 'Rich Web Experience - Conference for Front-End Developers - The Rich Web Experience' }

    static content = {
        scheduleLink(to: RichWebSchedulePage) { $("ul#top-nav li a", text: 'Schedule') }
    }

    RichWebSchedulePage goToSchedule() {
        scheduleLink.click()
        browser.page
    }
}

class RichWebSchedulePage extends Page {
    def days = [1: 'Tuesday', 2: 'Wednesday', 3: 'Thursday', 4: 'Friday']

    static content = {
        dailyLink { day -> $("a#tab-${day}") }
        dailyTitle { day -> $("div#day-${day} h3").text() }
    }

    void goToDay(day) {
        dailyLink(day).click()
    }

    void verifyDays() {
        (1..4).each { day ->
            goToDay(day)
            assert "${days[day]}, December $day" == dailyTitle(day)
        }
    }
}

Browser.drive {
    RWXHomePage rwx = to RWXHomePage
    rwx.goToSchedule()
        .verifyDays()
}
