/*
  @author ���V���l
   @date 2017/02/13
*/
/*
	memo
	ProductInfomation��bean��dao���g��
	�J�[�g���ɕ\�����鏤�i�̏�������Ă���
*/

package command;

import logic.RequestContext;
import logic.ResponseContext;
import logic.WebRequestContext;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


import bean.ProductImageBean;
import bean.ProductInformationBean;


import dao.AbstractDaoFactory;
import dao.ProductInformationDao;
import dao.ProductImageDao;
import dao.OraProductInformationDao;
import dao.OraProductImageDao;


import ex.LogicException;
import logic.ResponseContext;

public class DeleteCartCommand extends AbstractCommand {
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException{

		try{
			RequestContext req = getRequestContext();
			
			List cart = new ArrayList();
			/*���i���Ə��i��������cart���쐬*/
			if(req.getSessionAttribute("cart") == null){
				req.setSessionAttribute("cart",cart);
			}else{
				cart = (ArrayList)req.getSessionAttribute("cart");
			}
			
			/*�ꎞ�I��ProductId�����Ă���String*/
			String tempProductId = null;

			/*���i�ڍ׃y�[�W�őI�����ꂽ���i�́A���iID���J�[�g�ɒǉ������*/
			String searchProductId = req.getParameter( "productid" )[0];
			
			
			
			
			//�Z�b�V������cart�ɓo�^���ꂽid��searchId�ɓ���A�f�[�^�x�[�X����Ƃ��Ă���getId�Ɣ�ׂ邽�߂̕ϐ�
			String getId = null;
			String searchId = null;
			String loopS = "-1";
			
			
			//cart�̒�����productid�݂̂�list�֓����
			List<String> productImagePath = new ArrayList<String>();
			List<String> productId = new ArrayList<String>();
			
			Map<String,String> productInformation = new HashMap<String,String>();
			//Map<String,Object> returnProducts = new HashMap<String,Object>();
			
			/*
			����for����cart����key�l�ɓo�^����prodctid�̂ݎ��o����
			list�ɒǉ����Ă���
			*/
			
			
			
			//cart�̒��ɂ��鏤�i�̐��������[�v
			cart = (ArrayList)req.getSessionAttribute( "cart" );
			for(int i = 0;i < cart.size();i++){
				/*
				���g�͎���productInformation�Ɠ���Map
				produtInformation���g���Ƃ��������Ȃ�̂�
				local��Map���g��
				*/
				Map<String,String> localM = new HashMap<String,String>();
				/*
				cart���ɓ����Ă���Map������Ă���
				*/
				localM = (HashMap)cart.get(i);
				loopS = localM.get("productId");
				//cart.remove(i);
				/*for���ŉ񂳂�Ă���loopS�̒��ɁA���i�ڍ׃y�[�W����ǉ����ꂽ���i��productId�ŁA���łɑ��݂��Ă���J�[�g���ɓ���productId�������Ă��鏤�i���������T���B
				���ł�productId���o�^����Ă����ꍇ�͒������݂̂̕ύX�ɂȂ�*/
				if(loopS.equals(searchProductId)){
					req.setSessionAttribute("str",new String("�I�����ꂽ���i���J�[�g������폜���܂����B"));

					/*���̂��łɑ��݂��Ă���productId�������Ă���productInformation�ɁA���i�������̂ݕύX����localM�ŏ㏑��*/
					productInformation = localM;
					
					/*���̂Ƃ����cart.add���Ă��̂��ԈႢ*/
					cart.remove(i, productInformation);
					req.setSessionAttribute( "cart" , cart );
					
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		responseContext.setTarget("addcart");
			
		return responseContext;
	}
}