package todos

import geb.Browser
import org.openqa.selenium.Keys

Browser.drive {
    go 'http://todomvc.com/examples/angularjs'

    assert title == 'AngularJS • TodoMVC'
    assert $("#header").find("h1").text() == 'todos.todos'

    def todoCount = $("#todo-count")

    $("#new-todo") << 'Create Geb test' << Keys.ENTER

    waitFor { todoCount.text() == '1 item left' }
//    assert $(".ng-binding").text() == 'Create Geb test'

    println( $(".ng-binding")*.text() )

    def destroyElement = $(".destroy")
    interact {
        moveToElement(destroyElement)
        click()
    }


}