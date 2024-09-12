package org.example.servlet;

import org.example.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * GenericCalculator : 기존 Servlet의 불필요한 메소드를 제거한 추상클래스
 */
@WebServlet("/generic/calculate")
public class CalcGenericServlet extends GenericServlet {

    private static final Logger log = LoggerFactory.getLogger(CalcGenericServlet.class);

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("GenericServlet service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(operand1, operator, operand2);

        PrintWriter writer = response.getWriter();
        writer.print(result);
    }
}
