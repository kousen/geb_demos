import geb.Browser

Browser.drive {
    go 'http://www.springone2gx.com'
    assert title == 'SpringOne 2GX | September 14 - 17, 2015 | Washington DC'
    $("li#nav-schedule a").click()
    $("li#thurs a").click()
    assert title == 'Schedule: September 17, 2015 - SpringOne 2GX 2015'
}