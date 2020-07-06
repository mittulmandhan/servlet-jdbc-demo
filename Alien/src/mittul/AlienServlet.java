package mittul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlienServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("in servlet");
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String name = req.getParameter("aname");
		String id = req.getParameter("aid");

		pw.println("Welcome " + name + "!");
		pw.println("Your id is " + id);

		pw.close();
	}
}
