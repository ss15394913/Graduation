/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.PurchaseOrderBean;
import ex.IntegrationException;
 
/*�����̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface PurchaseOrderDao  {
	/*�S�Ă̒����̏����擾���郁�\�b�h*/
	public List getPurchaseOrders() throws IntegrationException;
	/*�����̏���o�^���郁�\�b�h�B�߂�l�́A�������琶�����ꂽ����ID*/
	public int setPurchaseOrder(PurchaseOrderBean purchaseOrder)
	throws IntegrationException;
}