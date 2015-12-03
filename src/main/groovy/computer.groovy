import geb.Browser

Browser.drive {
    go 'http://www.ismycomputeron.com'
    assert $("font").text() == 'YES'
}