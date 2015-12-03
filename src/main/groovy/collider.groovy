import geb.Browser

Browser.drive {
    go 'http://hasthelargehadroncolliderdestroyedtheworldyet.com/'
    assert title == 'Has the Large Hadron Collider destroyed the world yet?'
    assert $("div#main").text() == "NOPE."
}
