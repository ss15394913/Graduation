package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.FavoriteBean;
import bean.MemberBean;
import bean.ProductBean;
import bean.ProductImageBean;
import bean.TagBean;
import dao.AbstractDaoFactory;
import dao.FavoriteDao;
import dao.MemberDao;
import dao.ProductDao;
import dao.ProductImageDao;
import dao.TagDao;
import ex.IntegrationException;
import ex.LogicException;
import logic.RequestContext;
import logic.ResponseContext;

/**
 *@className UserStatusCommand
 *@author �͖�,�F�Ö�
 *@date 2017/01/31
 *@description �A�J�E���g���A���C�ɓ��菤�i�A�������ߏ��i
 */

public class ShowMyPageCommand extends AbstractCommand{

	public ResponseContext execute(ResponseContext responseContext) throws LogicException{
		/*RequestContext�̃C���X�^���X���擾*/
		RequestContext requestContext = getRequestContext();

		/*Dao���炨�C�ɓ���\�S�������List*/
		List favoriteList = new ArrayList();
		/*����̂��C�ɓ��菤�iID�̂ݓ����List*/
		ArrayList<String> memberFavoriteList =
		new ArrayList<String>();
		/*���i�S��������List*/
		List productList = new ArrayList();
		/*����̂��C�ɓ��菤�i������List*/
		ArrayList<ProductBean> memberProductList =
		new ArrayList<ProductBean>();

		/*���͂��ꂽ�p�����[�^���󂯎��*/
		int memberId = Integer.parseInt(requestContext.getSessionAttribute("login").toString());

		/*MemberBean�̃C���X�^���X*/
		MemberBean member = new MemberBean();

		/*ProductImageBean�̏�񂪊i�[���Ă���ϐ�*/
		ProductImageBean productsImageBean = new ProductImageBean();

		/*���i�摜��ID���i�[���Ă���ϐ�*/
		String imageProductId = null;

		/*�^�O�̃��X�g��S���擾���邽�߂̕ϐ�*/
		List tags = new ArrayList();

		/*�I�X�X�����i�̂݊i�[�������X�g*/
		List tagsName = new ArrayList();

		/*�����o�[���X�g��S���擾�̂��߂̃��X�g*/
		List allMemberList = new ArrayList();

		/*���i�摜��S���擾�̂��߂̃��X�g*/
		List allProductsImage = new ArrayList();

		/*�ŏI�I�ɕԂ����C�ɓ��菤�i���X�g���i�[����Map*/
		Map favoriteProductsInfo = new HashMap();

		/*�ŏI�I�ɕԂ��������ߏ��i���X�g�i�[����Map*/
		Map adviceProductsInfo = new HashMap();

		/*forEach�����q�ɂ��邽�߂�List�֓o�^(���C�ɓ��菤�i�p)*/
		List favoriteInfoList = new ArrayList();

		/*forEach�����q�ɂ��邽�߂�List�֓o�^(�������Z�[���p)*/
		List adviceInfoList = new ArrayList();
		
		try{
		/*�v���t�B�[���̎擾�����[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[*/

			/*AbstractDaoFactory�̃C���X�^���X���擾*/
			AbstractDaoFactory factory = AbstractDaoFactory.getFactory();

			/*MemberDao�̃C���X�^���X���擾*/
			MemberDao memberDao = factory.getMemberDao();

			/*�����o�[���X�g��S���擾*/
			allMemberList = memberDao.getMembers();

			Iterator iterator = allMemberList.iterator();

			while(iterator.hasNext()){

				member = (MemberBean)iterator.next();
				if(memberId == member.getMemberId()){
					break;
				}
			}
		/*--------------------------------------------------------------*/
			
/*���C�ɓ���ꗗ�̎擾�����[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[*/

			/*FavoriteDao�^�̕ϐ��ɂ�OraFavoriteDao�C���X�^���X������*/
			FavoriteDao favoriteDao = factory.getFavoriteDao();
			/*ProductDao�^�̕ϐ��ɂ�OraProductDao�C���X�^���X������*/
			ProductDao productDao = factory.getProductDao();
			/*���C�ɓ���\�S�����擾*/
			favoriteList = favoriteDao.getFavorites();
			
			Iterator favoIterator = favoriteList.iterator();
			while(favoIterator.hasNext()){
				/*���C�ɓ���\�̓��e�����[�v���Ɉꌏ������*/
				FavoriteBean favoriteBean =  (FavoriteBean)favoIterator.next();
				/*���C�ɓ����\�������������ID��
				���C�ɓ���\�ɓo�^����Ă���ID���ׁA
				���������ID�ƌ��т��Ă��鏤�iID������*/
				if(memberId == favoriteBean.getMemberId()){
					memberFavoriteList.add(favoriteBean.getProductId());
				}
			}
			/*---------------------------------------------------------*/
			
			/*ProductImageDao�̃C���X�^���X���擾*/
			ProductImageDao productImage = factory.getProductImageDao();

			/*ProductsImage���X�g��S���擾*/
			allProductsImage = productImage.getProductImages();
			
			/*Product�\��S���擾���鏈��------------------------*/
			productList = productDao.getProducts();
			
			Iterator proIterator = productList.iterator();
			while(proIterator.hasNext()){
				/*���i��񂪃��[�v���Ɉꌏ������*/
				ProductBean productBean =  (ProductBean)proIterator.next();
				
				/*���i�摜�̃C�e���[�^����*/
				Iterator favoriteImageIterator = allProductsImage.iterator();
				while(favoriteImageIterator.hasNext()){
					productsImageBean
					= (ProductImageBean)favoriteImageIterator.next();
					/*ProductImageBean�̏��iID���i�[*/
					imageProductId = productsImageBean.getProductId();
					
					Iterator favoriteProductIdIterator 
						= memberFavoriteList.iterator();
					while(favoriteProductIdIterator.hasNext()){
						/*���C�ɓ��菤�iID���ꌏ���i�[�����*/
						String favoriteProductId 
							= (String)favoriteProductIdIterator.next();
					/*memberFavoriteList���ɂ���
						�����̏��iID�̂ǂꂩ�ƍ��v���鏤�iID�̏��i������*/
					if(favoriteProductId.equals(productBean.getProductId()) && favoriteProductId.equals(imageProductId)){
						favoriteProductsInfo = new HashMap();
						
						favoriteProductsInfo.put("productBean",productBean);
						favoriteProductsInfo.put("productsImageBean",productsImageBean);
						/*List��Map���i�[*/
						/*(���C�ɓ����productBean��productImageBean)*/
						favoriteInfoList.add(favoriteProductsInfo);
						}
					}
				}
			}
			/*----------------------------------------------------*/

/*�������Z�[���p�̏����[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[�[*/
			/*-------�^�O�̃I�X�X�����i�݂̂𒊏o���鏈��---------*/

			TagDao tagDao = factory.getTagDao();
			/*Tag�\��S���擾*/
			tags = tagDao.getTags();

			Iterator tagIterator = tags.iterator();
			while(tagIterator.hasNext()){
				TagBean tagBean = (TagBean)tagIterator.next();
				String tagName = tagBean.getTagName();

				if(tagName.equals("�I�X�X��")){
					tagsName.add(tagBean);
				}
			}
			/*-------------------------------------------------------*/
			
			/*�������ߏ��i�Ƃ��̏��i�摜�𒊏o���鏈���|�|�|�|�|�|�|*/
			Iterator tagNameIterator = tagsName.iterator();
			
			while(tagNameIterator.hasNext()){
				TagBean tagNameBean
				= (TagBean)tagNameIterator.next();
				/*�I�X�X�����i��ProductId���i�[*/
				String tagProductId = tagNameBean.getProductId();
				/*�I�X�X���̏��i��ID�͏o�Ă���*/
				Iterator productsIterator = productList.iterator();
				while(productsIterator.hasNext()){
					ProductBean productBean
					= (ProductBean)productsIterator.next();
				/*���i��ProductId���i�[*/
					String productId = productBean.getProductId();
					
					Iterator productsImageIterator 
							= allProductsImage.iterator();
					while(productsImageIterator.hasNext()){
						productsImageBean 
							= (ProductImageBean)productsImageIterator.next();
						/*ProductImageBean��productId���i�[*/
						imageProductId = productsImageBean.getProductId();
						if(productId.equals(tagProductId) && productId.equals(imageProductId)){
							adviceProductsInfo = new HashMap();
							adviceProductsInfo.put("productBean",productBean);
							adviceProductsInfo.put("productsImageBean",productsImageBean);
							/*List��Map���i�[(�������Z�[����productBean��productImageBean)*/
							adviceInfoList.add(adviceProductsInfo);
						}
					}
				}
			}
			/*-----------------------------------------------------*/
		}catch(IntegrationException e){
			throw new LogicException(e.getMessage(), e);
		}
		/*�A�J�E���g���\���p�̃��X�g*/
		requestContext.setRequestAttribute("member",member);

		/*���C�ɓ��菤�i�Ɖ摜�\���p��List*/
		requestContext.setRequestAttribute("favoriteInfoList",favoriteInfoList);

		/*�������Z�[���̏��i�Ɖ摜�\���p��List*/
		requestContext.setRequestAttribute("adviceInfoList",adviceInfoList);

		/*�]����̃r���[���w��*/
		responseContext.setTarget("mypage");

		/*return�Ō��ʂ�Ԃ�*/
		return responseContext;
	}
}