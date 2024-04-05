package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO 
{
	int k=0;
   public int Update(UserBean ub)
   {
	   try
	   {
		   Connection con=DBconnection.getCon();
		   PreparedStatement ps=con.prepareStatement
				   ("Update userreg51 set addr=?,mid=?,phno=? where uname=? and pword=?");
		   ps.setString(1, ub.getAddr());
		   ps.setString(2, ub.getMid());
		   ps.setLong(3, ub.getPhno());
		   ps.setString(4, ub.getUname());
		   ps.setString(5, ub.getPword());
		   k=ps.executeUpdate();
		   
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return k;
   }

}
