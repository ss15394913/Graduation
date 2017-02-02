package dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;


public class Accessor{
	private Connection Connect;

	public void connect(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connect = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","shop_admin", "admin");
			System.out.println("ê⁄ë±ê¨å˜");
			Connect.setAutoCommit(false);
			
		}
		catch(ClassNotFoundException e){
			System.out.println("class:Accessor_method:connect() ClassNotFoundException");
		}
		catch(SQLException e){
			System.out.println("class:Accessor_method:connect() SQLException");
		}
		catch(Exception e){
			System.out.println("class:Accessor_method:connect() Exception");
		}
	}
	
	public  void write(String sql){
		try{ 
			Statement st = Connect.createStatement();
			System.out.println(sql);
			
			st.executeUpdate(sql);
			System.out.println("1234567890-");
			commit();
			System.out.println("yahhoooo");
			st.close();
		}
		catch(SQLException e){
			System.out.println("ks");
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println("unk");
			System.out.println(e.getMessage());
		}
	}


	public void commit(){
		try{
			Connect.commit();
		}
		catch(SQLException e){}
		catch(Exception e){}
	}
	
	public void close(){
		try{
			
			Connect.close();
		}
		catch(SQLException e){}
		catch(Exception e){}
	}
}