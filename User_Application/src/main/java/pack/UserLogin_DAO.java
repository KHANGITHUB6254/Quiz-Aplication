package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

public class UserLogin_DAO 
{
	UserBean ub=null;
	public UserBean login(HttpServletRequest req)
	{
		try
		{
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("Select *from userreg51 where uname=? and pword=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ub=new UserBean();
				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setAdd(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ub;
	}

}
