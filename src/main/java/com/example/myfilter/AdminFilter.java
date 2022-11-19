package com.example.myfilter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {

  public void init(FilterConfig config) throws ServletException {
  }

  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest req = (HttpServletRequest)request;
    HttpSession session = req.getSession();
    if (session.getAttribute("username") == null && !req.getRequestURI().endsWith("admin/account")) {
      req.getRequestDispatcher("login.jsp").forward(request, response);
    } else {
      chain.doFilter(request, response);
    }
  }
}
