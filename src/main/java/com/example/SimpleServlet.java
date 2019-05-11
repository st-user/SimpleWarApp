package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app/simple")
@SuppressWarnings("serial")
public class SimpleServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 req.setCharacterEncoding("UTF-8");
		System.out.println("requestCharacterEncoding : " + req.getServletContext().getRequestCharacterEncoding());
		System.out.println("req.getCharacterEncoding() : " + req.getCharacterEncoding());

		String hello = req.getParameter("hello");
		if (hello != null) {
			System.out.println("hello : " + req.getParameter("hello"));
		} else {
			System.out.println("body : " + req.getReader().readLine());
		}
	}
}
