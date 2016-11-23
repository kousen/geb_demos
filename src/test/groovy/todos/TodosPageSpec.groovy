package todos

import geb.spock.GebReportingSpec
import org.openqa.selenium.Keys

class TodosPageSpec extends GebReportingSpec {

    def 'add and delete a todo'() {
        given:
        TodosPage page = to(TodosPage)

        when:
        page.addToDo('Create Geb test')

        then:
        waitFor { page.numberOfToDoItems == old(page.numberOfToDoItems) + 1 }

        page.toDoItemTexts == ['Create Geb test']

        when:
        page.removeFirstToDoItem()

        then:
        waitFor { page.numberOfToDoItems == old(page.numberOfToDoItems) - 1 }
    }
}
