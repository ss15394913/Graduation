/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.CategoryBean;
import ex.IntegrationException;

/*�J�e�S���̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface CategoryDao {
	/*�S�ẴJ�e�S���̏����擾���郁�\�b�h*/
	public List getCategories() throws IntegrationException;
}