package mittul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class IdFilter
 */
@WebFilter("/addAlien")
public class IdFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("in filter");

		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println(req.getParameter("aname").trim().isEmpty());

		int id = req.getParameter("aid") != null && !req.getParameter("aid").trim().isEmpty()
				? Integer.parseInt(req.getParameter("aid"))
				: 0;
		String name = req.getParameter("aname")!=null && !req.getParameter("aname").trim().isEmpty()?req.getParameter("aname"):"";
		
//		System.out.println(name.trim().isEmpty());
		System.out.println(req.getParameter("aid").trim().isEmpty());

		if (id >= 1 && !name.trim().isEmpty() && !req.getParameter("aid").trim().isEmpty())
			chain.doFilter(request, response);
		else if (req.getParameter("aid").trim().isEmpty())
			out.println("You have not provided Alien ID");
		else if (id < 1)
			out.println("Id is not valid");
		else if (name.trim().isEmpty())
			out.println("You have not provided Alien Name");
		else
			out.println("unknown error!");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
