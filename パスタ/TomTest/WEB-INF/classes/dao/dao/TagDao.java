/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.TagBean;
import ex.IntegrationException;

/*�^�O�̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface TagDao {
	/*�S�Ẵ^�O�̏����擾���郁�\�b�h*/
	public List getTags() throws IntegrationException;
}