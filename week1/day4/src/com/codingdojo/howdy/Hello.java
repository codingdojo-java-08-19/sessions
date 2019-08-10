package com.codingdojo.howdy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
//		String personName = request.getParameter("name");
//		String[] people = { "George", "Sally", "Holly" };
		
		
		HttpSession session = request.getSession();
		
		String nameFromForm = (String) session.getAttribute("personFromForm");
		
		
		if (session.getAttribute("people") == null) {
			System.out.println("people is null");
			session.setAttribute("people", new ArrayList<String>());
		}
		
		ArrayList<String> people = (ArrayList<String>) session.getAttribute("people");
		
		
		System.out.println("Name is " + nameFromForm);
		
		System.out.println("people ... " + people);
		
//		response.setContentType("text/html");
		
		request.setAttribute("name", nameFromForm);
		request.setAttribute("people", people);
		
		
		RequestDispatcher view = request.getRequestDispatcher("hello.jsp");
		
		view.forward(request, response);
//		
//		PrintWriter out = response.getWriter();
//		
//		out.write("<h1>Hello " + name + "</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		
		ArrayList<String> people = (ArrayList<String>) session.getAttribute("people");
		
		
		
		people.add(name);
		
		session.setAttribute("personFromForm", name);
		System.out.println("posting content " + name);
//		doGet(request, response);
		response.sendRedirect("/Howdy/Hello");
	}

}
