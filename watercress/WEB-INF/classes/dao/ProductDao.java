/*
  @author �r�c��a
*/
package dao;

import java.util.List;
import bean.ProductBean;
import ex.IntegrationException;

/*���i�̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface ProductDao {
	/*�S�Ă̏��i�̏����擾���郁�\�b�h*/
	public List getProducts() throws IntegrationException;
}