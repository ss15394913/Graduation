/*
  author 池田大和
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MemberBean;
import ex.IntegrationException;
import ex.ConnectorException;
import ex.IllegalSQLException;

/*会員の情報を取得するために利用するデータアクセスオブジェクト*/
public class OraMemberDao implements MemberDao {
	/*全ての会員の情報を取得するメソッド*/
	public List getMembers() throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*問い合わせの結果を格納するBeanを格納するリスト変数の宣言*/
		ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		
		/*データベースへの接続*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*オートコミットを無効にする*/
			connection.setAutoCommit(false);
			
			/*ステートメントを生成する*/
			statement = connection.createStatement();
			
			/*SQL文を持つ変数の宣言*/
			String sql = "select member_id, member_name, member_kana, "
			+" member_zip_code, member_address, member_phone_number, "
			+ "to_char(member_birthday, 'YYYY/mm/dd'), "
			+ "member_email, member_password, member_status_id "
			+ "from member";
			
			/*SQLを実行し、結果をResultSetに格納する*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*表に対応するBeanをインスタンス化する*/
				MemberBean member = new MemberBean();
				/*BeanにSQLの結果を格納する*/
				member.setMemberId(result.getInt(1));
				member.setMemberName(result.getString(2));
				member.setMemberKana(result.getString(3));
				member.setMemberZipCode(result.getString(4));
				member.setMemberAddress(result.getString(5));
				member.setMemberPhoneNumber(result.getString(6));
				member.setMemberBirthday(result.getString(7));
				member.setMemberEmail(result.getString(8));
				member.setMemberPassword(result.getString(9));
				member.setMemberStatusId(result.getInt(10));
				/*リストにBeanを格納する*/
				members.add(member);
			}
			/*コミットを行う*/
			connection.commit();
			/*ResultSet、Statement、Connectionをクローズする*/
			result.close();
			statement.close();
			/*例外が発生したら、finally句でクローズを行う*/
		}catch(SQLException e){
			try{
				/*ロールバックを行う*/
				connection.rollback();
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(),e2);
			}
			throw new IllegalSQLException(e.getMessage(),e);
		}finally{
			try{
				if(result != null){
					result.close();
				}
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(), e2);
			}finally{
				try{
					if(statement != null){
						statement.close();
					}
				}catch(SQLException e3){
					throw new IllegalSQLException(e3.getMessage(), e3);
				}finally{
					try{
						if(connection != null){
							connection.close();
						}
					}catch(SQLException e4){
						throw new IllegalSQLException(e4.getMessage(), e4);
					}
				}
			}
		}
		/*問い合わせの結果を格納するBeanを格納するリストを返す*/
		return members;
	}
	
	/*新しい会員の登録を行うメソッド*/
	public void registMember(MemberBean member) throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*データベースへの接続*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*オートコミットを無効にする*/
			connection.setAutoCommit(false);
			
			/*SQL文を持つ変数の宣言*/
			String sql = 
			"insert into member values(member_id_seq.NEXTVAL, ?, ?, ?, " +
			"?, ?, to_date(?,'YYYY/mm/dd'), ?, ? ,?)";
			
			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setString(1, member.getMemberName());
			preparedStatement.setString(2, member.getMemberKana());
			preparedStatement.setString(3, member.getMemberZipCode());
			preparedStatement.setString(4, member.getMemberAddress());
			preparedStatement.setString(5, member.getMemberPhoneNumber());
			preparedStatement.setString(6, member.getMemberBirthday());
			preparedStatement.setString(7, member.getMemberEmail());
			preparedStatement.setString(8, member.getMemberPassword());
			preparedStatement.setInt(9, member.getMemberStatusId());
			
			/*SQLを実行し、結果をResultSetに格納する*/
			preparedStatement.executeUpdate();
			
			/*コミットを行う*/
			connection.commit();
			/*ResultSet、Statement、Connectionをクローズする*/
			preparedStatement.close();
			connection.close();
			/*例外が発生したら、finally句でクローズを行う*/
		}catch(SQLException e){
			try{
				/*ロールバックを行う*/
				connection.rollback();
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(),e2);
			}
			throw new IllegalSQLException(e.getMessage(),e);
		}finally{
			try{
				if(result != null){
					result.close();
				}
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(), e2);
			}finally{
				try{
					if(preparedStatement != null){
						preparedStatement.close();
					}
				}catch(SQLException e3){
					throw new IllegalSQLException(e3.getMessage(), e3);
				}finally{
					try{
						if(connection != null){
							connection.close();
						}
					}catch(SQLException e4){
						throw new IllegalSQLException(e4.getMessage(), e4);
					}
				}
			}
		}
	}
	
	/*引数のBeanのmemberIdに一致するIDを持つ会員の情報の変更するメソッド*/
	public void editMember(MemberBean member) throws IntegrationException {
		/*データベースの接続、表データの取得で使用する変数の宣言*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*データベースへの接続*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*オートコミットを無効にする*/
			connection.setAutoCommit(false);
			
			/*SQL文を持つ変数の宣言*/
			String sql = "update member set member_name = ?, "
			+ "member_kana = ?, member_zip_code = ?,"
			+ "member_address = ?, member_phone_number = ?, "
			+ "member_birthday = to_date(?,'YYYY/mm/dd'), "
			+ "member_email = ?, member_password = ?, "
			+ "member_status_id = ? where member_id = ?";
			
			/*SQLの実行準備を行う*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Beanから値を取り出し、SQL文の?にその値を代入する*/
			preparedStatement.setString(1, member.getMemberName());
			preparedStatement.setString(2, member.getMemberKana());
			preparedStatement.setString(3, member.getMemberZipCode());
			preparedStatement.setString(4, member.getMemberAddress());
			preparedStatement.setString(5, member.getMemberPhoneNumber());
			preparedStatement.setString(6, member.getMemberBirthday());
			preparedStatement.setString(7, member.getMemberEmail());
			preparedStatement.setString(8, member.getMemberPassword());
			preparedStatement.setInt(9, member.getMemberStatusId());
			preparedStatement.setInt(10, member.getMemberId());
			
			/*SQLを実行し、結果をResultSetに格納する*/
			preparedStatement.executeUpdate();
			
			/*コミットを行う*/
			connection.commit();
			/*ResultSet、Statement、Connectionをクローズする*/
			preparedStatement.close();
			connection.close();
			/*例外が発生したら、finally句でクローズを行う*/
		}catch(SQLException e){
			try{
				/*ロールバックを行う*/
				connection.rollback();
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(),e2);
			}
			throw new IllegalSQLException(e.getMessage(),e);
		}finally{
			try{
				if(result != null){
					result.close();
				}
			}catch(SQLException e2){
				throw new IllegalSQLException(e2.getMessage(), e2);
			}finally{
				try{
					if(preparedStatement != null){
						preparedStatement.close();
					}
				}catch(SQLException e3){
					throw new IllegalSQLException(e3.getMessage(), e3);
				}finally{
					try{
						if(connection != null){
							connection.close();
						}
					}catch(SQLException e4){
						throw new IllegalSQLException(e4.getMessage(), e4);
					}
				}
			}
		}
	}
}