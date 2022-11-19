package com.example.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AccountController", value = "/admin/account")
public class AccountController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action != null && action.equalsIgnoreCase("logout")) {
      HttpSession session = request.getSession();
      session.removeAttribute("username");
    }
    request.getRequestDispatcher("login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")){
      session.setAttribute("username", username);
      request.getRequestDispatcher("listProducts.jsp").forward(request, response);
    } else {
      request.setAttribute("message", "Account is Invalid");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }

  }
}
