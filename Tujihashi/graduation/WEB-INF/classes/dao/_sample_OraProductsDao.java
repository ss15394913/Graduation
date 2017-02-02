package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tera.Product;
import exp.ResourceAccessException;

public class OraProductsDao implements ProductsDao{
	public void addProduct(Product p){
		Connection cn = null;
		PreparedStatement st = null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			cn.setAutoCommit(false);
			
			String sql = "insert into t_products(pid,name,price) values(?,?,?)";
			
			st = cn.prepareStatement(sql);
			
			st.setString(1,p.getPid());
			st.setString(2,p.getName());
			st.setString(3,p.getPrice());
			
			st.executeUpdate();
			
			cn.commit();
		}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(),e);
		}catch(SQLException e){
			try{
				cn.rollback();
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					throw new ResourceAccessException(e3.getMessage(),e3);
				}
			}
		}
	}
	public Product getProduct(String pid){
		return null;
	}
	public List getAllProducts(){
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList products = new ArrayList();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			cn.setAutoCommit(false);
			
			String sql = "select pid,name,price from t_products";
			
			st = cn.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()){
				Product p = new Product();
				
				p.setPid(rs.getString(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getString(3));
				
				products.add(p);
			}
			
			cn.commit();
		}catch(ClassNotFoundException e){
			throw new ResourceAccessException(e.getMessage(),e);
		}catch(SQLException e){
			try{
				cn.rollback();
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}
			throw new ResourceAccessException(e.getMessage(),e);
		}finally{
			try{
				if(st != null){
					st.close();
				}
			}catch(SQLException e2){
				throw new ResourceAccessException(e2.getMessage(),e2);
			}finally{
				try{
					if(cn != null){
						cn.close();
					}
				}catch(SQLException e3){
					throw new ResourceAccessException(e3.getMessage(),e3);
				}
			}
		}
		return products;
	}
}