package mylogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

public class LoginDao {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	    	
	        Class.forName("com.mysql.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs","root","harish254");
	        System.out.println("connection successful");
	        
	    }catch(Exception e){System.out.println(e);}
	    return con;  
	}
	
	public static int match(String username, String password){
		
		//System.out.println(username);
		//System.out.println(password);
		int status = 0;
		
	    try{ 
	        Connection con = getConnection();  
	        Statement stmt = con.createStatement();  
	        ResultSet rs = stmt.executeQuery("select * from test");
	        
	        while(rs.next()){
	        	System.out.println(rs.getString(1));
	        	System.out.println(rs.getString(2));
	        	if (rs.getString(1).equals(username) && rs.getString(2).equals(password)){
	        		status = 1;
	        		break;
	        	}
	        }
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}
}
