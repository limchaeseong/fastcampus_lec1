package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller : Dispatcher Servlet에게 받은 사용자 요청(Request)을 처리하고 ModelAndView를 반환.
public interface Controller {
    String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
