/*
  @author �r�c��a
*/
package dao;

import java.util.List;
import bean.ProductInformationBean;
import ex.IntegrationException;

/*���i�̏��(�݌ɐ��܂�)���擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface ProductInformationDao {
	/*�������ŕ��ёւ����A�S�Ă̏��i�̏��(�݌ɐ��܂�)���擾���郁�\�b�h*/
	public List getProductInformations() throws IntegrationException;
}