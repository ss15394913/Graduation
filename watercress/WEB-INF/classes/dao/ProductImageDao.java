/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.ProductImageBean;
import ex.IntegrationException;

/*���i�摜�̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface ProductImageDao {
	/*�S�Ă̏��i�摜�̏����擾���郁�\�b�h*/
	public List getProductImages() throws IntegrationException;
}