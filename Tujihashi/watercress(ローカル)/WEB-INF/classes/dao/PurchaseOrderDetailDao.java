/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.PurchaseOrderDetailBean;
import ex.IntegrationException;

/*�������ׂ̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface PurchaseOrderDetailDao {
	/*�S�Ă̒������ׂ̏����擾���郁�\�b�h*/
	public List getPurchaseOrderDetails() throws IntegrationException;
	/*�������ׂ�o�^���郁�\�b�h*/
	public void setPurchaseOrderDetail(
		PurchaseOrderDetailBean purchaseOrderDetail)
	throws IntegrationException;
}