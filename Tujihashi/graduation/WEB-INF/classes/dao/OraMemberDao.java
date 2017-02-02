/*
  author �r�c��a
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

/*����̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public class OraMemberDao implements MemberDao {
	/*�S�Ẳ���̏����擾���郁�\�b�h*/
	public List getMembers() throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g�ϐ��̐錾*/
		ArrayList<MemberBean> members = new ArrayList<MemberBean>();
		
		/*�f�[�^�x�[�X�ւ̐ڑ�*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*�I�[�g�R�~�b�g�𖳌��ɂ���*/
			connection.setAutoCommit(false);
			
			/*�X�e�[�g�����g�𐶐�����*/
			statement = connection.createStatement();
			
			/*SQL�������ϐ��̐錾*/
			String sql = "select member_id, member_name, member_kana, "
			+" member_zip_code, member_address, member_phone_number, "
			+ "to_char(member_birthday, 'YYYY/mm/dd'), "
			+ "member_email, member_password, member_status_id "
			+ "from member";
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			result = statement.executeQuery(sql);
			
			while(result.next()){
				/*�\�ɑΉ�����Bean���C���X�^���X������*/
				MemberBean member = new MemberBean();
				/*Bean��SQL�̌��ʂ��i�[����*/
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
				/*���X�g��Bean���i�[����*/
				members.add(member);
			}
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
			result.close();
			statement.close();
			/*��O������������Afinally��ŃN���[�Y���s��*/
		}catch(SQLException e){
			try{
				/*���[���o�b�N���s��*/
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
		/*�₢���킹�̌��ʂ��i�[����Bean���i�[���郊�X�g��Ԃ�*/
		return members;
	}
	
	/*�V��������̓o�^���s�����\�b�h*/
	public void registMember(MemberBean member) throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*�f�[�^�x�[�X�ւ̐ڑ�*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*�I�[�g�R�~�b�g�𖳌��ɂ���*/
			connection.setAutoCommit(false);
			
			/*SQL�������ϐ��̐錾*/
			String sql = 
			"insert into member values(member_id_seq.NEXTVAL, ?, ?, ?, " +
			"?, ?, to_date(?,'YYYY/mm/dd'), ?, ? ,?)";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
			preparedStatement.setString(1, member.getMemberName());
			preparedStatement.setString(2, member.getMemberKana());
			preparedStatement.setString(3, member.getMemberZipCode());
			preparedStatement.setString(4, member.getMemberAddress());
			preparedStatement.setString(5, member.getMemberPhoneNumber());
			preparedStatement.setString(6, member.getMemberBirthday());
			preparedStatement.setString(7, member.getMemberEmail());
			preparedStatement.setString(8, member.getMemberPassword());
			preparedStatement.setInt(9, member.getMemberStatusId());
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			preparedStatement.executeUpdate();
			
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
			preparedStatement.close();
			connection.close();
			/*��O������������Afinally��ŃN���[�Y���s��*/
		}catch(SQLException e){
			try{
				/*���[���o�b�N���s��*/
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
	
	/*������Bean��memberId�Ɉ�v����ID��������̏��̕ύX���郁�\�b�h*/
	public void editMember(MemberBean member) throws IntegrationException {
		/*�f�[�^�x�[�X�̐ڑ��A�\�f�[�^�̎擾�Ŏg�p����ϐ��̐錾*/
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		/*�f�[�^�x�[�X�ւ̐ڑ�*/
		try{
			connection 
			= new OracleConnector("shop_admin","admin").getConnection();
		}catch(IntegrationException e){
			throw new ConnectorException(e.getMessage(), e);
		}
		
		try{
			/*�I�[�g�R�~�b�g�𖳌��ɂ���*/
			connection.setAutoCommit(false);
			
			/*SQL�������ϐ��̐錾*/
			String sql = "update member set member_name = ?, "
			+ "member_kana = ?, member_zip_code = ?,"
			+ "member_address = ?, member_phone_number = ?, "
			+ "member_birthday = to_date(?,'YYYY/mm/dd'), "
			+ "member_email = ?, member_password = ?, "
			+ "member_status_id = ? where member_id = ?";
			
			/*SQL�̎��s�������s��*/
			preparedStatement = connection.prepareStatement(sql);
			
			/*Bean����l�����o���ASQL����?�ɂ��̒l��������*/
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
			
			/*SQL�����s���A���ʂ�ResultSet�Ɋi�[����*/
			preparedStatement.executeUpdate();
			
			/*�R�~�b�g���s��*/
			connection.commit();
			/*ResultSet�AStatement�AConnection���N���[�Y����*/
			preparedStatement.close();
			connection.close();
			/*��O������������Afinally��ŃN���[�Y���s��*/
		}catch(SQLException e){
			try{
				/*���[���o�b�N���s��*/
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