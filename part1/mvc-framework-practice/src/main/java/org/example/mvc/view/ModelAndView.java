package org.example.mvc.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class ModelAndView {
    private Object view;
    private Map<String, Object> model = new HashMap<>();

    public ModelAndView(String viewName) {
        view = viewName;
    }

    public String getViewName() {
        return (this.view instanceof String) ? this.view.toString() : null;
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }
}
