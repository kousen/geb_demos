package gebish

import geb.Module

class HighlightsModule extends Module {
    static content = {
        highlightsLink { text -> $("a", text: text).module(SelectableLinkModule) }
        jQueryLikeApi { highlightsLink("jQuery-like API") }
    }
}
