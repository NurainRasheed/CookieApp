package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

public class LoginServlet extends HttpServlet {
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("link.html").include(request, response);
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			if(password.equals("abc1234")) {
				out.print("<br>You have successfully logged in");
				out.print("<br>Welcome " + name);
				Cookie ck=new Cookie("name",name);
				response.addCookie(ck);
			}
			else
			{
				out.print("<br>Sorry! Username or pssword incorrect!");
				request.getRequestDispatcher("login.html").include(request, response);
			}
			
			out.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
