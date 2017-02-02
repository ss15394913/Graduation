/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.ProductStockBean;
import ex.IntegrationException;

/*���i�ꗗ��ʗp�̈ꗗ���擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface ProductCatalogDao {
	/*���i�̕��я����w�肷�邽�߂̒萔*/
	public static final int SORT_BY_PRICE_ASC = 1;
	public static final int SORT_BY_PRICE_DESC = 2;
	public static final int SORT_BY_PURCHASE_COUNT_ASC = 3;
	public static final int SORT_BY_PURCHASE_COUNT_DESC = 4;
	public static final int SORT_BY_NAME_ASC = 5;
	public static final int SORT_BY_NAME_DESC = 6;
	/*�S�Ă̏��i�̏����擾���郁�\�b�h�B�����ɂ���ĕ��ёւ��𐧌䂷��*/
	public List getProductCatalogs(int[] sortingRules) 
	throws IntegrationException;
	/*��L���\�b�h�̃I�[�o�[���[�h�B��L�̃��\�b�h���Ăяo��*/
	public List getProductCatalogs(int sortingRule)
	throws IntegrationException;
	/*��L���\�b�h�̃I�[�o�[���[�h�B��L�̃��\�b�h���Ăяo��*/
	public List getProductCatalogs()
	throws IntegrationException;
}