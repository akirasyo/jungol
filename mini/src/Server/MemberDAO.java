package Server;
import java.sql.*;
import java.net.*;
import java.util.*;
import Common.*;

public class MemberDAO{
	private Connection con;
	private String sql, url, oracleid, oraclepwd;
	private ResultSet rs;
	private PreparedStatement ps;
	private Member member;
	private Socket soc;
	public MemberDAO(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		oracleid="admin";
		oraclepwd="admin";
	}
	public MemberDAO(Member member, Socket soc) {
		this.member = member;
		this.soc = soc;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		url = "jdbc:oracle:thin:@localhost:1521:XE";
		oracleid="admin";
		oraclepwd="admin";
		boolean isdb = dbsearch(this.member);
		if(!isdb){
			int res = insert(member);
			new NetworkIn(this.soc).insert(String.valueOf(res), soc);
		}else{
			new NetworkIn(this.soc).insert(String.valueOf("-1"), soc);
		}
	}
	public boolean dbsearch(Member member){
		sql = "select * from pcmember where id = ?";
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public int insert(Member member){
		sql = "insert into pcmember values( idx_seq.nextval,?,?,?,?,?,0)";
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getTel());
			ps.setInt(3, member.getBirth());
			ps.setString(4, member.getId());
			ps.setString(5, member.getPwd());
			int res = ps.executeUpdate();
			System.out.println("insert(res)"+res);
			sql = "commit";
			ps = con.prepareStatement(sql);
			return res;
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}

	public String searchid(String name, int birth){
		  sql = "select * from pcmember where name = '"+name +"'and birth = '" + birth + "'";
		  try{
			  con = DriverManager.getConnection(url, oracleid, oraclepwd);
			  ps = con.prepareStatement(sql);
			  rs = ps.executeQuery();
			  while(rs.next()){
			  String id = rs.getString("id");
			  System.out.println(id);
			  return id;
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return null;
	}
	public String searchpw(String name, int birth, String id){
		sql = "select * from pcmember where name = '"+name +"'and birth = '" + birth + "' and id = '"+ id+"'";
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			String pwd = rs.getString("pwd");
			return pwd;
			}
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return null;
	}
	public ArrayList<Member> searchAll(){
		sql = "select * from pcmember";
		ArrayList<Member> al = new ArrayList<Member>();
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			   Member mem = new Member();
			   mem.setIdx(rs.getInt(1));
			   mem.setName(rs.getNString(2));
			   mem.setTel(rs.getNString(3));
			   mem.setBirth(rs.getInt(4));
			   mem.setId(rs.getNString(5));
			   mem.setPwd(rs.getNString(6));
			   mem.setMileage(rs.getInt(7));
			   al.add(mem);
		   }
			return al;
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		return null;
	}
	public boolean search(String name, String birth){
		sql = "select * from pcmember where name = ? and birth = ?";
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(birth));
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Member> editOfsearch(String name, String birth){
		sql = "select * from pcmember where name = ? and birth = ?";
		ArrayList<Member> al = new ArrayList<Member>();
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			ps.setNString(1, name);
			ps.setInt(2, Integer.parseInt(birth));
			rs = ps.executeQuery();
		while(rs.next()){
			Member mem = new Member();
			mem.setIdx(rs.getInt(1));
			mem.setName(rs.getString(2));
			mem.setTel(rs.getString(3));
			mem.setBirth(rs.getInt(4));
			mem.setId(rs.getString(5));
			mem.setPwd(rs.getString(6));
			mem.setMileage(rs.getInt(7));
			al.add(mem);
		}
		return al;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public int edit(String tel, String pwd, String name){
		sql = "update pcmember set tel = ?, pwd = ? where name = ?";
		try{
			con = DriverManager.getConnection(url, oracleid, oraclepwd);
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, pwd);
			ps.setString(3, name);
			int res = ps.executeUpdate();
			return res;
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
}