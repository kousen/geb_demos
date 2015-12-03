import geb.Browser
import geb.Module
import geb.Page

class SelectableLinkModule extends Module {
    boolean isSelected() {
        parent().hasClass("selected")
    }
}

class HighlightsModule extends Module {
    static content = {
        highlightsLink { text -> $("a", text: text).module(SelectableLinkModule) }
        jQueryLikeApi { highlightsLink("jQuery-like API") }
    }
}

class GebHomePage extends Page {
    static url = "http://gebish.org"

    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        highlights { $("#sidebar .sidemenu").module(HighlightsModule) }
        sectionTitles { $("#main h1")*.text() }
    }
}

Browser.drive {
    to GebHomePage

    highlights.jQueryLikeApi.click()

    assert sectionTitles == ["Navigating Content", "Form Control Shortcuts"]
    assert highlights.jQueryLikeApi.selected
}