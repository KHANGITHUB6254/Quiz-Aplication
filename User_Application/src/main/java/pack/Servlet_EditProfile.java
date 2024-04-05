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
@WebServlet("/edit")
public class Servlet_EditProfile extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
							throws ServletException, IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("Session Expired...!");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else
		{
			String fname=c[0].getValue();
			pw.println("page belongs to:"+fname+"<br>");
			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean)sct.getAttribute("ubean");
			pw.println("<form action='update' method='post'>");
			pw.println("Address: <input type='text' name='addr' value='"+ub.getAddr()+"'"+"<br>");
			pw.println("MailID: <input type='text' name='mid' value='"+ub.getMid()+"'"+"<br>");
			pw.println("PhoneNo:<input type='text' name='phno' value='"+ub.getPhno()+"'"+"<br>");
			pw.println("<input type='submit' value='update'><br>");
			pw.println("</form>");
			
		}
	}
}
