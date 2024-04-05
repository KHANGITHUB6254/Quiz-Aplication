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
@WebServlet("/update")
public class Servlet_UpdateProfile extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
							throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("session expired...!");
			RequestDispatcher rd =req.getRequestDispatcher("login.html");

					rd.include(req, res);
		}
		else
		{
			String fname=c[0].getValue();
			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean)sct.getAttribute("ubean");
			
			ub.setAdd(req.getParameter("addr"));
			ub.setMid(req.getParameter("mid"));
			ub.setPhno(Long.parseLong(req.getParameter("phno")));
			int k=new UpdateProfileDAO().Update(ub);
			pw.println("page belongs to:"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			if(k>0)
			{
				pw.println("profile updated sucessfully...!");
			}
			
		}
	}
}
