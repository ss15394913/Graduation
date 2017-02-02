/*
  @author �r�c��a
  @date 2017/01/26
*/

package command;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductInformationBean;
import dao.AbstractDaoFactory;
import dao.ProductInformationDao;

import logic.RequestContext;
import logic.ResponseContext;
import ex.IntegrationException;
import ex.LogicException;

/*�N���b�N���ꂽ���i�̏ڍׂ�\������R�}���h�̃N���X*/
public class ShowProductDetailCommand extends AbstractCommand{
	/*�N���b�N���ꂽ���i�̏ڍׂ�Ԃ����\�b�h*/
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{
		/*init���\�b�h�ɂ���ď�������Ă���RequestContext���擾����*/
		RequestContext requestContext = getRequestContext();
		
		/*�uDAO����󂯎�鏤�i�ڍׂ̃��X�g�v�̕ϐ���錾*/
		List allProductInformations = null;
		
		/*�u�ړI�̖��O�������i�́A���i�ڍׂ̃��X�g�v�̕ϐ���錾*/
		/*�����߂�l��ResponseContext�ɉ�����*/
		List returnProductInformations = null;
		
		/*���[�U�[���I���������i�̖��O���擾*/
		String selectedProductName
		= requestContext.getParameter("product_name")[0];
		
		try{
			/*���i�ڍׂ̕\����f�[�^���擾���邽�߂�DAO���擾����*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductInformationDao productInformationDao
			= factory.getProductInformationDao();
			
			/*DAO���珤�i�ڍו\�̃f�[�^���擾����*/
			allProductInformations
			= productInformationDao.getProductInformations();
			
			/*�C�e���[�^���g���A�擾�����\�̊e�s���m�F���ď������s��*/
			Iterator iterator = allProductInformations.iterator();
			while(iterator.hasNext()){
				/*�ꌏ�̏��i�ڍׂł���Bean���擾*/
				ProductInformationBean productInfo
				= (ProductInformationBean)iterator.next();
				/*�擾����Bean���̏��i���̕ϐ����A���[�U�[���I���������i�̖��O
				  �Ɠ����ł���Ȃ�A���X�|���X��List�ɂ���Bean��ǉ�����*/
				/*�I�΂ꂽ���O�̏��i�Ȃ�A���X�|���X�̓��e�ɒǉ������*/
				if(productInfo.getProductName().equals(selectedProductName)){
					returnProductInformations.add(productInfo);
				}
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*���X�|���X�ɁA�ړI�̖��O�������i�̏��i�ڍׂ̃��X�g��������*/
		responseContext.setResult(returnProductInformations);
		
		/*�]�����View�̖��O�����X�|���X�ɉ�����*/
		responseContext.setTarget("productdetail");
		
		/*�K�v�ȏ������I��������X�|���X��Ԃ�*/
		return responseContext;
	}
}