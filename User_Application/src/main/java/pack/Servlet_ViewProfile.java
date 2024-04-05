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
@WebServlet("/view")
public class Servlet_ViewProfile extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
							throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("Session Expired....!");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			pw.println("page belongs to:"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean)sct.getAttribute("ubean");
			pw.println("<br>"+ub.getFname()+"&nbsp&nbsp"
					+ub.getLname()+"&nbsp&nbsp"+ub.getAddr()+
					"&nbsp&nbsp"+ub.getMid()+"&nbsp&nbsp"
					+ub.getPhno());
			
		}
	}
}
