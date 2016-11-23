import geb.Browser

Browser.drive {
    go 'http://therichwebexperience.com'
    assert title == 'Rich Web Experience - Conference for Front-End Developers - The Rich Web Experience'
    $("ul#top-nav li a", text: 'Schedule').click()
    $("a#tab-3").click()
    assert $("div#day-3 h3").text() == "Thursday, December 3"
}