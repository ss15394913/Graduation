/*
  @author �r�c��a
*/
package dao;

import java.util.List;
import bean.MemberStatusBean;
import ex.IntegrationException;

/*����̏�Ԃ̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface MemberStatusDao {
	/*�S�Ẳ���̏�Ԃ̏����擾���郁�\�b�h*/
	public List getMemberStatuses() throws IntegrationException;
}