package org.example.servlet;

import org.example.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {

    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig config;

    // 초기화
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        log.info("init");
        this.config = servletConfig;

    }    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("Servlet service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(operand1, operator, operand2);

        PrintWriter writer = response.getWriter();
        writer.print(result);
    }

    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}
