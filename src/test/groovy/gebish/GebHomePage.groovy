package gebish

import geb.Page

class GebHomePage extends Page {
    static url = "http://gebish.org"

    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        highlights { $("#sidebar .sidemenu").module(HighlightsModule) }
        sectionTitles { $("#main h1")*.text() }
    }
}