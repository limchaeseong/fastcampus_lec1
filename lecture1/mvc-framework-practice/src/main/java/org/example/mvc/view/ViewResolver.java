package org.example.mvc.view;

// ViewResolver : Dispatcher Servlet에게 전달받은 view name으로 view를 찾음.
public interface ViewResolver {
    View resolveView(String viewName);
}
