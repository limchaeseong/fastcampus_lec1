package org.example.mvc;


import org.example.mvc.controller.*;
import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping {

    // key: path, value : controller
    private Map<HandlerKey, Controller> mappings = new HashMap<>();

    void init() {
        // AnnotationHandlerMapping으로 이동
        // mappings.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        // mappings.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form.jsp"));

        mappings.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
    }

    public Controller findHandler(HandlerKey handlerKey){
        return mappings.get(handlerKey);
    }
}
