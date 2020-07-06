package mittul;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

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

		try {
			Connection con = DatabaseUtility.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO alien VALUES(" + id + ", '" + name + "');");
			System.out.println("added to database");
		} catch (SQLIntegrityConstraintViolationException e) {
			pw.println("alien already exists");
			System.out.println("alien already exists");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pw.println("Welcome " + name + "!");
		pw.println("Your id is " + id);

		pw.close();
	}
}
