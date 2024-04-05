		package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/log")
public class Servlet_UserLogin extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
							throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		
		UserBean ub=new UserLogin_DAO().login(req);
		if(ub==null)
		{
			pw.println("Invalid Login Process....!");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else
		{
			ServletContext sct=this.getServletContext();
			sct.setAttribute("ubean",ub);
			Cookie ck=new Cookie("fname",ub.getFname());
			res.addCookie(ck);
			pw.println("Welcome user:"+ub.getFname()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}
}
