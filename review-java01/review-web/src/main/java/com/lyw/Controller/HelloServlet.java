package com.lyw.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyw.entity.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*resp.setContentType("text/html;charset=utf-8");
    String result = "<h1>你好啊</h1>";
    resp.getWriter().println(result);*/

    //resp.sendRedirect("http://www.baidu.com");


    String username = req.getParameter("username");
//    resp.setContentType("text/html;charset=utf-8");
//    resp.getWriter().println("get:你好啊 " + username);
    ServletContext servletContext = getServletContext();
    servletContext.setAttribute("username", username);

    Cookie cookie = new Cookie("cookie", "cookie");
    HttpSession session = req.getSession();
    session.setAttribute("session", "session's value");
    cookie.setMaxAge(60);
    resp.addCookie(cookie);
    req.setAttribute("request", "request");

    req.getRequestDispatcher("/two").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//    String requestURI = req.getRequestURI();
//    StringBuffer requestURL = req.getRequestURL();
//    req.setCharacterEncoding("utf-8");
//    String username = req.getParameter("username");
//    Enumeration parameterNames = req.getParameterNames();
//    while (parameterNames.hasMoreElements()) {
//      String parameter = req.getParameter((String) parameterNames.nextElement());
//    }
    resp.setContentType("text/html;charset=utf-8");
//    resp.getWriter().println("post:你好啊 " + username);
//    resp.getWriter().println(requestURL + "--" + requestURI);

//    resp.sendRedirect("/two?username=" + username);

    ObjectMapper ob = new ObjectMapper();
    Student student = new Student("张三", 18);
    String s = ob.writeValueAsString(student);
    resp.getWriter().println(s);

  }
}
