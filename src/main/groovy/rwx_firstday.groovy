import geb.Browser

Browser.drive {
    go 'http://therichwebexperience.com'
    assert title.contains('Rich Web')

    $("#top-nav").find("a", text: 'Schedule').click()
    assert $('h1')*.text()[0] == 'Schedule'
    assert $("#tab-3").text().contains('Thursday')
}