import geb.Browser

Browser.drive {
    go 'http://www.google.com'

    $("input", name: "q").value("Geb testing")
    $("button", name: "btnG").click()

    waitFor { $("#search").displayed }

    assert $("#search").text().contains("gebish.org")
}