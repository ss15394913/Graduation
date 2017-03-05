package command;

import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;
/**
 *@author �͖�
 *@date 2017/01/31
 */
public class AddFavoriteCommand extends AbstractCommand{

	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		/*�e�N���X�̃��\�b�h�𗘗p��RequestContext�̃C���X�^���X���擾*/
		RequestContext requestContext = getRequestContext();

		FavoriteBean favorite = new FavoriteBean();
		/*���C�ɓ���\�ɒǉ����鏤�i��ID���擾���i�[--------*/
		favorite.setProductId( (String)requestContext.getParameter("productId")[0]);

		/*���C�ɓ���\�ɒǉ���������ID���擾*/
		String id = (String)requestContext.getSessionAttribute("login");
		int memberId = Integer.parseInt(id);

		/*���C�ɓ���\�ɒǉ���������ID���i�[*/
		favorite.setMemberId(memberId);

		try{

		/*���C�ɓ���ǉ������[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			/*FavoriteDao�^�̕ϐ��ɂ�OraFavoriteDao�C���X�^���X������*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*Favorite�\�ɒǉ�*/
			favoriteDao.addFavorite(favorite);

		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}
		responseContext.setTarget("productlist");

		return responseContext;
	}
}