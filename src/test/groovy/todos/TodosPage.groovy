package todos

import geb.Page
import org.openqa.selenium.Keys

class TodosPage extends Page {
    static url = "http://todomvc.com/examples/angularjs"

    static at = { title == 'AngularJS • TodoMVC' }

    static content = {
        addField { $("#new-todo") }
        destroyLink(required: false) { $(".destroy") }
        items(required: false) { $(".view").find("label") }
    }

    void addToDo(String todo) {
        waitFor { addField.displayed }

        addField << todo << Keys.ENTER
    }

    List<String> getToDoItemTexts() {
        items.collect { it.text().trim() }
    }

    Integer getNumberOfToDoItems() {
        items.size()
    }

    void removeFirstToDoItem() {
        def firstToDoItem = items.first()
        def firstDestroyLink = destroyLink.first()

        interact {
            moveToElement(firstToDoItem)
        }

        waitFor { firstDestroyLink.displayed }

        firstDestroyLink.click()
    }
}
