package org.example.mvc;

// Handler Mapping : Handler(=Controller) 목록 중 request를 처리할 수 있는 컨트롤러를 찾는 역할
public interface HandlerMapping {
    Object findHandler(HandlerKey handlerKey);
}
