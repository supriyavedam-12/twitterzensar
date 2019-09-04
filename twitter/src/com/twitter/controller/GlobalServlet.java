package com.twitter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twitter.entity.TwitterEmployee;
import com.twitter.service.TwitterService;
import com.twitter.service.TwitterServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        out.println("<html><body>");
		
		String option = request.getParameter("ac");
		if(option.equals("login"))
		{
			//here name,pass,email,address are the name of html boxes
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			String address=request.getParameter("address");
		    TwitterEmployee te=new TwitterEmployee();
		    te.setName(name);
		    te.setPass(pass);
		    te.setEmail(email);
		    te.setAddress(address);
		    TwitterServiceInterface ts=TwitterService.createServiceObject();
		    int i=ts.createProfile(te);
		    if(i>0)
			{
				out.println("profile created");
			}
			else
			{
				out.println("could not create profile");
			}
			
			
		}
		if(option.equals("register"))
		{
			
		}
		if(option.equals("time")) {
		}
		out.println("</html></body>");
	}
}


		    
	


