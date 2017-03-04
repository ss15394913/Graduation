/*
  @className OrderDataConfirmationCommand
  @author �r�c��a
  @date 2017/01/31
*/
package command;

import ex.LogicException;
import ex.IntegrationException;
import logic.RequestContext;
import logic.ResponseContext;

import bean.ProductBean;
import dao.AbstractDaoFactory;
import dao.ProductDao;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

/*���͂��ꂽ���������m�F�����ʂ�\������R�}���h�̃N���X*/
public class OrderDataConfirmationCommand extends AbstractCommand {
	/*���͂��ꂽ���������Z�b�V�����X�R�[�v�ɕۑ����A
	�������鏤�i�̏������X�|���X�Ɋ܂߂ĕԂ����\�b�h*/
	public ResponseContext execute(ResponseContext responseContext)
	throws LogicException {
		/*init���\�b�h�ɂ���ď�������Ă���RequestContext���擾����*/
		RequestContext requestContext = getRequestContext();
		
		/*���N�G�X�g�X�R�[�v������o���A�Z�b�V�����X�R�[�v�ɓo�^�������l��
		�L�[���`����B�����ł́A���͒l���K����ł���L�[���`����B*/
		String[] singleValueKeyNames = {"familyname","name","zipcode",
			"prefectures","city","blocknumber","buildingname","phonenumber",
			"requesteddate","requestedtime","paymentmethod","creditcardnumber",
			"securitycode","expirationdate","orderprice","commission",
			"totalprice"
		};
		
		/*���N�G�X�g�X�R�[�v�ɂ����L�z����̖��O�̃L�[�̒l���A
		�Z�b�V�����X�R�[�v�ɒǉ�����*/
		for(String keyName : singleValueKeyNames){
			requestContext.setSessionAttribute(
				keyName,requestContext.getParameter(keyName)[0]);
		}
		
		/*���N�G�X�g�X�R�[�v������o���A�Z�b�V�����X�R�[�v�ɓo�^�������l��
		�L�[���`����B�����ł́A���͒l�������ɂȂ�L�[���`����B*/
		String[] multipleValueKeyNames = {"ordercounts","orderproducts"};
		
		/*���N�G�X�g�X�R�[�v�ɂ����L�z����̖��O�̃L�[�̒l���A
		�Z�b�V�����X�R�[�v�ɒǉ�����*/
		for(String keyName : multipleValueKeyNames){
			requestContext.setSessionAttribute(
				keyName,requestContext.getParameter(keyName));
		}
		
		/*���N�G�X�g�X�R�[�v���璍�����鏤�i��ID���擾����*/
		String[] orderProductsId
		= requestContext.getParameter("orderproducts");
		
		/*Arrays.AsList���\�b�h�𗘗p���A�������鏤�i��ID��String�z���
		ArrayList�ɕϊ�����*/
		ArrayList<String> orderProductsIdList
		= new ArrayList<String>(Arrays.asList(orderProductsId));
		
		/*�S�Ă̏��i�̃f�[�^���i�[����ϐ��̐錾*/
		List<ProductBean> products = new ArrayList<ProductBean>();
		
		/*�������鏤�i�̃f�[�^���i�[����ϐ��̐錾*/
		/*�����߂�l��ResponseContext�ɉ�����*/
		List<ProductBean> orderProducts = new ArrayList<ProductBean>();
		
		try{
			/*���i�̕\����f�[�^���擾���邽�߂�DAO���擾����*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
			ProductDao productDao = factory.getProductDao();
			
			/*�S�Ă̏��i�̃f�[�^���擾����*/
			products = productDao.getProducts();
			
			/*�C�e���[�^���g���A�擾�����\�̊e�s���m�F���ď������s��*/
			Iterator iterator = products.iterator();
			while(iterator.hasNext()){
				/*�擾����Bean���̏��iID���A���[�U�[���I���������i��ID
				  �Ɠ����ł���Ȃ�A���X�|���X��List�ɂ���Bean��ǉ�����*/
				ProductBean product = (ProductBean)iterator.next();
				if(orderProductsIdList.contains(product.getProductId())){
					orderProducts.add(product);
				}
			}
			
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		
		/*���X�|���X�ɁA�������鏤�i�ڍׂ̃��X�g��������*/
		responseContext.setResult(orderProducts);
		
		/*�]�����View�̖��O�����X�|���X�ɉ�����*/
		responseContext.setTarget("ordercheck"); 
		
		/*�K�v�ȏ������I��������X�|���X��Ԃ�*/
		return responseContext;
	}
}

/*
�X�R�[�v�ɕۑ�����f�[�^�̃L�[������\������񋓂���B
"familyname"		����
"name"				���O
"zipcode"			�X�֔ԍ�
"prefectures"		�s���{��
"city"				�s�撬��
"blocknumber"		�Ԓn
"buildingname"		������
"phonenumber"		�d�b�ԍ�
"requesteddate"		�z�B��]��
"requestedtime"		�z�B��]����
"paymentmethod"		�x�������@�i��������N���W�b�g�J�[�h�j
"creditcardnumber"	�N���W�b�g�J�[�h�ԍ�
"securitycode"		�N���W�b�g�J�[�h�̃Z�L�����e�B�R�[�h
"expirationdate"	�N���W�b�g�J�[�h�̗L������
"orderprice"		�������鏤�i�̋��z
"commission"		�萔���i������̍ۂ̒ǉ������j
"totalprice"		�������鏤�i�̋��z�Ǝ萔���̍��v

"ordercount"		����������̔z��
					�P�Ԗڂ̏��i�̌���[0]�A�Q�Ԗڂ̏��i��[1]�E�E�E
"orderproducts"		�������鏤�i��ID�̔z��
*/
