import geb.Browser
import geb.Page

class S2GXHomePage extends Page {
    static url = 'http://www.springone2gx.com'

    static at = { title == 'SpringOne 2GX | September 14 - 17, 2015 | Washington DC' }

    static content = {
        scheduleLink(to: SchedulePage) { $("li#nav-schedule a") }
    }

    SchedulePage goToSchedule() {
        scheduleLink.click()
        browser.page
    }
}

class SchedulePage extends Page {
    def dates = [14: 'mon', 15: 'tues', 16: 'wed', 17: 'thurs']

    static content = {
        conferenceDates { 14..17 }
        dailyLink { day -> $("li#${dates[day]} a") }
        dailyTitle { day -> "Schedule: September ${day}, 2015 - SpringOne 2GX 2015" }
    }

    void goToDay(day) {
        dailyLink(day).click()
    }

    void verifyDays() {
        conferenceDates.each { day ->
            goToDay(day)
            assert title == dailyTitle(day)
        }
    }
}

Browser.drive {
    S2GXHomePage s2gx = to S2GXHomePage
    s2gx.goToSchedule()
        .verifyDays()
}
