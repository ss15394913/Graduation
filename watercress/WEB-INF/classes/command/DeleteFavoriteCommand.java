package command;

import ex.LogicException;
import ex.IntegrationException;

import bean.FavoriteBean;
import bean.ProductBean;

import logic.RequestContext;
import logic.ResponseContext;
import logic.CommandFactory;

import dao.AbstractDaoFactory;
import dao.FavoriteDao;

/**
 *@author �F�Ö�
 *@date 2017/01/31
 */
public class DeleteFavoriteCommand extends AbstractCommand{
	
	public ResponseContext execute( ResponseContext responseContext )
	throws LogicException{
		
		/*�e�N���X�̃��\�b�h�𗘗p��RequestContext�̃C���X�^���X���擾*/
		RequestContext requestContext = getRequestContext();
		
		FavoriteBean favorite = new FavoriteBean();
		/*���C�ɓ���\�ɒǉ����鏤�i��ID���擾���i�[--------*/
		favorite.setProductId( (String)requestContext.getParameter( "productid" )[0]);
		
		/*���C�ɓ���\�ɒǉ���������ID���擾-----------*/
		String id = (String)requestContext.getSessionAttribute("login");
		int memberId = Integer.parseInt(id);
		
		/*���C�ɓ���\����폜���鏤�i�̉��ID���i�[*/
		favorite.setMemberId(memberId);
		
		try{
		/*���C�ɓ���폜�����[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			/*FavoriteDao�^�̕ϐ��ɂ�OraFavoriteDao�C���X�^���X������*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*Favorite�\����폜*/
			favoriteDao.removeFavorite(favorite);
			
		/*MyPage��\������ׂ̏����擾*/
			AbstractCommand command = CommandFactory.getCommand("UserStatusCommand");
			responseContext = command.execute(responseContext);
			
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(),e);
		}
		
		
		return responseContext;
	}
}