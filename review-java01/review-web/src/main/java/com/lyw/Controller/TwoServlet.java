package com.lyw.Controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TwoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String username = req.getParameter("username");
    ServletContext servletContext = getServletContext();
    Object username = servletContext.getAttribute("username");
    String value = req.getCookies()[0].getValue();
    resp.setContentType("text/html;charset=utf-8");
    String session = (String) req.getSession().getAttribute("session");
    String request = (String) req.getAttribute("request");

    resp.getWriter().println("twoServlet下的doGet请求 -> "
            + username + "<br/>cookie值 -> " + value
            + "<br/>request -> " + request + "<br/>session -> " + session
    );

  }
}
