/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.ProductStockBean;
import ex.IntegrationException;

/*���i�̍݌ɐ����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface ProductStockDao {
	/*�S�Ă̏��i�̍݌ɐ����擾���郁�\�b�h*/
	public List getProductStocks() throws IntegrationException;
	/*������Bean���̕ϐ�productId�ƈ�v���鏤�i�̍݌ɐ����A
	  ������Bean���̕ϐ�productStockCount�Ɠ������ɕύX���郁�\�b�h*/
	/*���i�̍݌ɐ���ύX���郁�\�b�h*/
	public void setProductStock(ProductStockBean productStockBean) 
	throws IntegrationException;
}