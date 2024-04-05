package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegDAO 
{
	public int k=0;
	public int register(UserBean ub)
	{
		try
		{
			 Connection con=DBconnection.getCon();
			 PreparedStatement ps=con.prepareStatement
					 ("insert into UserReg51 values(?,?,?,?,?,?,?)");
			 ps.setString(1, ub.getUname());
			 ps.setString(2, ub.getPword());
			 ps.setString(3, ub.getFname());
			 ps.setString(4, ub.getLname());
			 ps.setString(5, ub.getAddr());
			 ps.setString(6, ub.getMid());
			 ps.setLong(7,ub.getPhno());
			 k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
		
	}

}
