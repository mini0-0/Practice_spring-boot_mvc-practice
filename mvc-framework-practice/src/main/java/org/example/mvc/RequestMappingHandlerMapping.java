package org.example.mvc;
import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping {
    private Map<HandlerKey, Controller> mapping = new HashMap<>();

    void init() {
//        mapping.put(new HandlerKey(RequestMethod.GET,"/"), new HomeController());
        mapping.put(new HandlerKey(RequestMethod.GET,"/users"), new UserListController());
        mapping.put(new HandlerKey(RequestMethod.POST,"/users"), new UserCreateController());
        mapping.put(new HandlerKey(RequestMethod.GET,"/users/form"), new ForwardController("/user/form"));


    }

    public Controller findHandler(HandlerKey handlerKey) {
        return mapping.get(handlerKey);
    }
}
