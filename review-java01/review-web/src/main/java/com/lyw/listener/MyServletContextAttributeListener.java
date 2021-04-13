package com.lyw.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {
  @Override
  public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
    System.out.println("servletcontext's value added ...");
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
    System.out.println("servletcontext's value remove...");
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
    System.out.println("servletcontext's value update...");
  }
}
