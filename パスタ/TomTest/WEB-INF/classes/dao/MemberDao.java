/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.MemberBean;
import ex.IntegrationException;

/*����̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface MemberDao {
	/*�S�Ẳ���̏����擾���郁�\�b�h*/
	public List getMembers() throws IntegrationException;
	/*�V��������̓o�^���s�����\�b�h*/
	public void registMember(MemberBean member) throws IntegrationException;
	/*������Bean��memberId�Ɉ�v����ID��������̏��̕ύX���郁�\�b�h*/
	public void editMember(MemberBean member) throws IntegrationException;
}