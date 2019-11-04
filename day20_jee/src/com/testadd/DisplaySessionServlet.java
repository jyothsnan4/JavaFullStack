package com.testadd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplaySessionServlet
 */
public class DisplaySessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		ArrayList<Integer> a=new ArrayList<>();
		PrintWriter out=response.getWriter();
		if(session.isNew()){
		int count=0;
		a.clear();
		out.println(session.getCreationTime());
		int num=Integer.parseInt(request.getParameter("num"));
		out.println("Number enetered now is:"+num);
		a.add(num);
		count++;
		session.setAttribute("count", count);
		session.setAttribute("list", a);
		out.println("You have enetered 1 number");
		}
		else{
			int num=Integer.parseInt(request.getParameter("num"));
			int count= (int) session.getAttribute("count");
			ArrayList<Integer> a1=(ArrayList<Integer>) session.getAttribute("list");
			out.println(session.getCreationTime());
			out.println("You have enetered"+(count)+" numbers previously.They are:");
			for(int i=0;i<count;i++)
				out.println(a1.get(i));
			out.println("Number enetered now is:"+num);
			a1.add(num);
			count++;
			session.setAttribute("list", a1);
			session.setAttribute("count", count);
			out.println("Now there are:"+count+" numbers");
		}
		
	}

}
