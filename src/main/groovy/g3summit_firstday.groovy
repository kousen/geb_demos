import geb.Browser

Browser.drive {
    go 'http://g3summit.com'
    assert title.contains('G3 Summit')

    $("#top-nav").find("a", text: 'Schedule').click()
    assert $('h1').text() == 'Schedule'
    assert $(".current").find("h3").text().contains('Monday')
}