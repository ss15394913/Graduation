/*
  @author �r�c��a
*/
package dao;

import java.util.List;

import bean.FavoriteBean;
import ex.IntegrationException;

/*���C�ɓ���̏����擾���邽�߂ɗ��p����f�[�^�A�N�Z�X�I�u�W�F�N�g*/
public interface FavoriteDao {
	/*�S�Ă̂��C�ɓ���̏����擾���郁�\�b�h*/
	public List getFavorites() throws IntegrationException;
	/*���C�ɓ����o�^���郁�\�b�h*/
	public void addFavorite(FavoriteBean favorite) throws IntegrationException;
	/*���C�ɓ�����폜���郁�\�b�h*/
	public void removeFavorite(FavoriteBean favorite) throws IntegrationException;
}