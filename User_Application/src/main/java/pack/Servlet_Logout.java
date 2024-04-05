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
@WebServlet("/Logout")
public class Servlet_Logout extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
							throws ServletException, IOException
	 {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("Session Expired....!");
			
		}else
		{
			ServletContext sct=this.getServletContext();
			sct.removeAttribute("ubean");
			c[0].setMaxAge(0);
			res.addCookie(c[0]);
			pw.println("user logged out sucessfully...!<br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, res);
	 }
}
