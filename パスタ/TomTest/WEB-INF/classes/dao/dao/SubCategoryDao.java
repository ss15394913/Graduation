/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.SubCategoryBean;
import ex.IntegrationException;

/*�T�u�J�e�S���̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface SubCategoryDao {
	/*�S�ẴT�u�J�e�S���̏����擾���郁�\�b�h*/
	public List getSubCategories() throws IntegrationException;
}