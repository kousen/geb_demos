package g3summit

import geb.Page

import java.time.DayOfWeek

class G3SchedulePage extends Page {

    static url = 'https://g3summit.com/conference/fort_lauderdale/2016/11/schedule'

    static at = { $('h1').text() == 'Schedule' }

    static List<String> getDays() {
        (DayOfWeek.MONDAY..DayOfWeek.THURSDAY).collect {
            it.toString().toLowerCase().capitalize()
        }
    }

    static content = {
        dailyLink { day -> $(".day-tabs").find("a.tab", text: day) }
        dailyTitle { $(".current").find("h3") }
    }

    G3SchedulePage goToDay(day) {
        dailyLink(day).click()
        browser.page
    }

    String getDailyTitle(day) {
        goToDay(day)
        return dailyTitle.text()
    }

}
