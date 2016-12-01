package g3summit

import geb.Browser

Browser.drive {
    go 'https://g3summit.com'
    assert title.contains('G3 Summit')
    $("#top-nav").find("a", text: 'Schedule').click()
    assert $('h1').text() == 'Schedule'
    $("a#tab-4").click()
    assert $(".current").find("h3").text().contains('Thursday')
}