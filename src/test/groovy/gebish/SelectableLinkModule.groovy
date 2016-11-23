package gebish

import geb.Module

class SelectableLinkModule extends Module {
    boolean isSelected() {
        parent().hasClass("selected")
    }
}
