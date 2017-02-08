package command;

import java.util.List;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import bean.PurchaseHistoryBean;
import dao.PurchaseHistoryDao;
import dao.OraPurchaseHistoryDao;
import dao.AbstractDaoFactory;

import logic.ResponseContext;
import logic.RequestContext;
import logic.WebRequestContext;
import ex.IntegrationException;
import ex.LogicException;

/**
 *@className ShowPurchaseHistoryCommand
 *@author �͖�
 *@date 2017/01/31
 *@description 
 */

public class ShowPurchaseHistoryCommand extends AbstractCommand{
	
	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		/*RequestContext�̃C���X�^���X���擾*/
		RequestContext requestContext = new WebRequestContext();
		
		/*getParameter�Ńy�[�W�ԍ����擾*/
		int pageNum = Integer.parseInt(requestContext.getParameter("pageNumber")[0]);
		
		/*�w�����X�g��S���擾�̂��߂̃��X�g*/
		List allPurchaseList = null;
		
		/*return�ŕԂ����߂̃��X�g*/
		List returnPurchaseList = null;
		
		try{
			/*AbstractDaoFactory�̃C���X�^���X���擾*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			
			/*PurchaseHistoryDao�̃C���X�^���X���擾*/
			PurchaseHistoryDao purchaseHistoryDao = factory.getPurchaseHistoryDao();
			/*�w�����X�g��S���擾*/
			allPurchaseList = purchaseHistoryDao.getPurchaseHistories();
			
			/*�w�����X�g�����[�v*/
			for(int i = 0; i <= allPurchaseList.size();){
				
				/*�\����10�ɍi��*/
				if((pageNum - 1) * 10 <= i && i <= pageNum * 10 - 1){
					
					PurchaseHistoryBean purchaseHistory = 
							(PurchaseHistoryBean)allPurchaseList.get(i);
					
					returnPurchaseList.add(allPurchaseList.get(i));
			
					i++;
				}
			}
		
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*�Z�b�V�����X�R�[�v�ɃC���X�^���X��ۑ�*/
		requestContext.setSessionAttribute("pageNum",pageNum);
		
		/*response�ő���l���Z�b�g*/
		responseContext.setResult(returnPurchaseList);
		
		/*�]����̃r���[���w��*/
		responseContext.setTarget("orderhistory");
		
		/*return�Ō��ʂ�Ԃ�*/
		return responseContext;
	}
}