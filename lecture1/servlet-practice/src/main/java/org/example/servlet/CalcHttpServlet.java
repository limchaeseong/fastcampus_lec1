package org.example.servlet;

import org.example.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServlet : GenericServlet에서 기본 service 메소드가 구현 되어있음.(override를 통해 메소드 별 처리방법 구현 가능)
 */
@WebServlet("/http/calculate")
public class CalcHttpServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(CalcHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("HttpServlet service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(operand1, operator, operand2);

        PrintWriter writer = response.getWriter();
        writer.print(result);
    }
}
