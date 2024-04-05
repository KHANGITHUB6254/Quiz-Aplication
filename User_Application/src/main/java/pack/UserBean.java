package pack;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable
{
  private String uname,pword,fname,lname,addr,mid;
  private long phno;
  UserBean(){}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPword() {
	return pword;
}
public void setPword(String pword) {
	this.pword = pword;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getAddr() {
	return addr;
}
public void setAdd(String addr) {
	this.addr = addr;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public long getPhno() {
	return phno;
}
public void setPhno(long phno) {
	this.phno = phno;
}
  
}
