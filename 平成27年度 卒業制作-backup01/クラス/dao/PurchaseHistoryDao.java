/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.PurchaseHistoryBean;
import ex.IntegrationException;

/*�w���������擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface PurchaseHistoryDao {
	/*�w���������擾����r���[���g�p���āA�w�������̏����擾���郁�\�b�h*/
	public List getPurchaseHistories() throws IntegrationException;
}