package g3summit

import geb.Page

class G3SummitPage extends Page {
    static url = "https://g3summit.com"

    static at = { title.contains('G3 Summit') }

    static content = {
        scheduleLink(to: G3SchedulePage) { $("#top-nav").find("a", text: 'Schedule') }
    }

    G3SchedulePage goToSchedule() {
        scheduleLink.click()
        return browser.page
    }
}
