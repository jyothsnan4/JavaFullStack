package com.testadd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse res
	 * ponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> names=new ArrayList<String>();
		names.add("Tanmayi");
		names.add("Christopher");
		names.add("Anitha");
		names.add("Jyothsna");
		String input=request.getParameter("name1");
		PrintWriter out=response.getWriter();
		int hit=0;
		for(int i=0;i<4;i++){
		if(input.equals(names.get(i)))
			//out.println(input+"->Candidate in the class");
			hit++;	
	}
		if(hit!=0)
			out.println(input+"->Candidate in the class");
		else
			out.println(input+"->Candidate not in the class");
			
	}

}
