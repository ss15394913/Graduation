/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.PurchaseRankingBean;
import ex.IntegrationException;

/*�w�����ŕ��ёւ������i�ꗗ���擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface PurchaseRankingDao{
	/*�w�����ŕ��ёւ������i�ꗗ���擾����r���[���g�p���āA
	  ���i�̏����擾���郁�\�b�h*/
	public List getPurchaseRanking() throws IntegrationException;
}