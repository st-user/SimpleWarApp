package com.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
		System.out.println("requestCharacterEncoding : " + req.getServletContext().getRequestCharacterEncoding());
		System.out.println("req.getCharacterEncoding() : " + req.getCharacterEncoding());
		System.out.println("responseCharacterEncoding : " + req.getServletContext().getResponseCharacterEncoding());
		System.out.println("resp.getCharacterEncoding() : " + resp.getCharacterEncoding());

		String hello = req.getParameter("hello");
		if (hello != null) {
			System.out.println("hello( expected:E3 81 82 ) : " + toHexString(req.getParameter("hello")));
		} else {
			System.out.println("body( expected:E3 81 82 ) : " + toHexString(req.getReader().readLine()));
		}
		resp.getWriter().println("あ");
	}

	// To avoid the platform default encoding to affect assertion, I check the text in hexadecimal format.
	private String toHexString(String str) throws UnsupportedEncodingException {
		String ret = "";
		for (int b : str.getBytes("UTF-8")) {
			if (b < 256) {
				b += 256;
			}
			ret += " ";
			ret += Integer.toHexString(b).toUpperCase();
		}
		return ret;
	}
}
